package com.kotlinsg.kworkshopapp.base.mvp

interface BasePresenter {
    fun attachView(view: BaseView)
    fun detachView()
    fun viewShown()
    fun viewHidden()
}