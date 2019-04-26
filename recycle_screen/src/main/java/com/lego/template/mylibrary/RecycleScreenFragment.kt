package com.lego.template.mylibrary

import com.lego.template.base.mvvm.BaseFragment
import com.lego.template.base.mvvm.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecycleScreenFragment : BaseFragment() {

    private val viewModel: RecycleScreenViewModel by viewModel()

    override fun getViewModel(): BaseViewModel = viewModel

}