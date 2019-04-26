package com.lego.template.map_screen

import com.lego.template.base.mvvm.BaseFragment
import com.lego.template.base.mvvm.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapScreenFragment : BaseFragment() {

    private val viewModel: MapScreenViewModel by viewModel()

    override fun getViewModel(): BaseViewModel = viewModel

}