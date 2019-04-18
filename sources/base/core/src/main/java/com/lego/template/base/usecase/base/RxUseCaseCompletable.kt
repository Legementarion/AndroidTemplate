package com.lego.template.base.usecase.base

import com.lego.template.util.setDefaultSchedulers
import io.reactivex.Completable
import io.reactivex.observers.DisposableCompletableObserver

abstract class RxUseCaseCompletable<T, Params> : BaseRxUseCase<Params, Completable, DisposableCompletableObserver>() {
    final override fun execute(observer: DisposableCompletableObserver, params: Params) {
        addDisposable(
            buildUseCaseObservable(params)
                .setDefaultSchedulers()
                .subscribeWith(observer)
        )
    }
}