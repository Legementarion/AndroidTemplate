package com.lego.template.util.pagination

import io.reactivex.Single
import io.reactivex.disposables.Disposable

class Paginator<T>(
    private val requestFactory: (Int) -> Single<List<T>>,
    private val viewController: ViewController<T>) {

    companion object {
        private const val FIRST_PAGE = 1
    }

    interface ViewController<T> {
        fun showEmptyProgress(show: Boolean)
        fun showEmptyError(show: Boolean, error: Throwable? = null)
        fun showEmptyView(show: Boolean)
        fun showData(show: Boolean, data: List<T> = emptyList())
        fun showErrorMessage(error: Throwable)
        fun showRefreshProgress(show: Boolean)
        fun showPageProgress(show: Boolean)
    }


    private var currentState: State<T> = EMPTY()
    private var currentPage = 0
    private val currentData = mutableListOf<T>()
    private var disposable: Disposable? = null

    fun restart() {
        currentState.restart()
    }

    fun refresh() {
        currentState.refresh()
    }

    fun loadNewPage() {
        currentState.loadNewPage()
    }

    fun release() {
        currentState.release()
    }

    private fun loadPage(page: Int) {
        disposable?.dispose()
        disposable = requestFactory.invoke(page)
            .subscribe(
                { currentState.newData(it) },
                { currentState.fail(it) }
            )
    }

    private interface State<T> {
        fun restart() {}
        fun refresh() {}
        fun loadNewPage() {}
        fun release() {}
        fun newData(data: List<T>) {}
        fun fail(error: Throwable) {}
    }

    private inner class EMPTY : State<T> {

        override fun refresh() {
            currentState = EmptyProgress()
            viewController.showEmptyProgress(true)
            loadPage(FIRST_PAGE)
        }

        override fun release() {
            currentState = RELEASED()
        }
    }

    private inner class EmptyProgress : State<T> {

        override fun restart() {
            loadPage(FIRST_PAGE)
        }

        override fun newData(data: List<T>) {
            if (data.isNotEmpty()) {
                currentState = DATA()
                currentData.apply {
                    clear()
                    addAll(data)
                }
                currentPage = FIRST_PAGE
                viewController.apply {
                    showData(true, currentData)
                    showEmptyProgress(false)
                }
            } else {
                currentState = EmptyData()
                viewController.apply {
                    showEmptyProgress(false)
                    showEmptyView(true)
                }
            }
        }

        override fun fail(error: Throwable) {
            currentState = EmptyError()
            viewController.apply {
                showEmptyProgress(false)
                showEmptyError(true, error)
            }
        }

        override fun release() {
            currentState = RELEASED()
        }
    }

    private inner class EmptyError : State<T> {

        override fun restart() {
            currentState = EmptyProgress()
            viewController.apply {
                showEmptyError(false)
                showEmptyProgress(true)
            }
            loadPage(FIRST_PAGE)
        }

        override fun refresh() {
            currentState = EmptyProgress()
            viewController.apply {
                showEmptyError(false)
                showEmptyProgress(true)
            }
            loadPage(FIRST_PAGE)
        }

        override fun release() {
            currentState = RELEASED()
        }
    }

    private inner class EmptyData : State<T> {

        override fun restart() {
            currentState = EmptyProgress()
            viewController.apply {
                showEmptyView(false)
                showEmptyProgress(true)
            }
            loadPage(FIRST_PAGE)
        }

        override fun refresh() {
            currentState = EmptyProgress()
            viewController.apply {
                showEmptyView(false)
                showEmptyProgress(true)
            }
            loadPage(FIRST_PAGE)
        }

        override fun release() {
            currentState = RELEASED()
        }
    }

    private inner class DATA : State<T> {

        override fun restart() {
            currentState = EmptyProgress()
            viewController.apply {
                showData(false)
                showEmptyProgress(true)
            }
            loadPage(FIRST_PAGE)
        }

        override fun refresh() {
            currentState = REFRESH()
            viewController.showRefreshProgress(true)
            loadPage(FIRST_PAGE)
        }

        override fun loadNewPage() {
            currentState = PageProgress()
            viewController.showPageProgress(true)
            loadPage(currentPage + 1)
        }

        override fun release() {
            currentState = RELEASED()
        }
    }

    private inner class REFRESH : State<T> {

        override fun restart() {
            currentState = EmptyProgress()
            viewController.apply {
                showData(false)
                showRefreshProgress(false)
                showEmptyProgress(true)
            }
            loadPage(FIRST_PAGE)
        }

        override fun newData(data: List<T>) {
            if (data.isNotEmpty()) {
                currentState = DATA()
                currentData.apply {
                    clear()
                    addAll(data)
                }
                currentPage = FIRST_PAGE
                viewController.apply {
                    showRefreshProgress(false)
                    showData(true, currentData)
                }
            } else {
                currentState = EmptyData()
                currentData.clear()
                viewController.apply {
                    showData(false)
                    showRefreshProgress(false)
                    showEmptyView(true)
                }
            }
        }

        override fun fail(error: Throwable) {
            currentState = DATA()
            viewController.apply {
                showRefreshProgress(false)
                showErrorMessage(error)
            }
        }

        override fun release() {
            currentState = RELEASED()
        }
    }

    private inner class PageProgress : State<T> {

        override fun restart() {
            currentState = EmptyProgress()
            viewController.apply {
                showData(false)
                showPageProgress(false)
                showEmptyProgress(true)
            }
            loadPage(FIRST_PAGE)
        }

        override fun newData(data: List<T>) {
            if (data.isNotEmpty()) {
                currentState = DATA()
                currentData.addAll(data)
                currentPage++
                viewController.apply {
                    showPageProgress(false)
                    showData(true, currentData)
                }
            } else {
                currentState = AllData()
                viewController.showPageProgress(false)
            }
        }

        override fun refresh() {
            currentState = REFRESH()
            viewController.apply {
                showPageProgress(false)
                showRefreshProgress(true)
            }
            loadPage(FIRST_PAGE)
        }

        override fun fail(error: Throwable) {
            currentState = DATA()
            viewController.apply {
                showPageProgress(false)
                showErrorMessage(error)
            }
        }

        override fun release() {
            currentState = RELEASED()
        }
    }

    private inner class AllData : State<T> {

        override fun restart() {
            currentState = EmptyProgress()
            viewController.apply {
                showData(false)
                showEmptyProgress(true)
            }
            loadPage(FIRST_PAGE)
        }

        override fun refresh() {
            currentState = REFRESH()
            viewController.showRefreshProgress(true)
            loadPage(FIRST_PAGE)
        }

        override fun release() {
            currentState = RELEASED()
        }
    }

    private inner class RELEASED : State<T> {
        init {
            disposable?.dispose()
        }
    }
}
