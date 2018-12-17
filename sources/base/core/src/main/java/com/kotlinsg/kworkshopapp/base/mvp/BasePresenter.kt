package com.demoss.idp.base.mvp

import com.kotlinsg.kworkshopapp.base.mvp.BaseView

interface BasePresenter {

    fun attachView(view: BaseView)
    fun detachView()
    fun viewShown()
    fun viewHidden()
}