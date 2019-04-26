package com.lego.template.base.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.lego.template.base.livedata.Event
import com.lego.template.base.navigation.NavigationCommand

abstract class BaseViewModel : ViewModel() {

    // FOR ERROR HANDLER
    protected val snackbarErrors = MutableLiveData<Event<Int>>()
    val snackBarError: LiveData<Event<Int>> get() = snackbarErrors

    // FOR NAVIGATION
    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>> = _navigation

    /**
     * Convenient method to handle navigation from a [ViewModel]
     */
    fun navigate(directions: NavDirections) {
        _navigation.value = Event(NavigationCommand.To(directions))
    }
}