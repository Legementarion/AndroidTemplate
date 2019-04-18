package com.lego.template.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.lego.template.base.mvp.BasePresenter
import com.lego.template.base.mvp.BaseView

abstract class BaseFragment<Presenter : BasePresenter> : Fragment(), BaseView {

    abstract val presenter: Presenter
    abstract val layoutResourceId: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(layoutResourceId, container, false).also {
            presenter.attachView(this)
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.viewShown()
    }

    override fun onPause() {
        super.onPause()
        presenter.viewHidden()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    final override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    final override fun hideKeyboard() {
        (activity?.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager)
                .hideSoftInputFromWindow((activity?.currentFocus ?: View(context)).windowToken, 0)
    }

}