package com.lego.template.chat_module

import com.lego.template.base.mvvm.BaseFragment
import com.lego.template.base.mvvm.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatScreenFragment : BaseFragment() {

    private val viewModule: ChatScreenViewModel by viewModel()

    override fun getViewModel(): BaseViewModel = viewModule
}