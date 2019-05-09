package com.lego.template.home

import com.lego.template.base.mvvm.BaseViewModel

class HomeViewModel : BaseViewModel() {

    fun moveToMaps() = navigate(HomeFragmentDirections.actionHomeFragmentToMapScreenFragment())


    fun moveToRecycler() = navigate(HomeFragmentDirections.actionHomeFragmentToRecycleScreenFragment())


    fun moveToChat() = navigate(HomeFragmentDirections.actionHomeFragmentToChatScreenFragment())

}