package com.kotlinsg.kworkshopapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlinsg.kworkshopapp.appB.R
import com.kotlinsg.kworkshopapp.di.Logger
import com.kotlinsg.kworkshopapp.di.MainActivityComponent
import com.kotlinsg.kworkshopapp.tools.Toaster
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var log: Logger
    @Inject
    lateinit var toast: Toaster

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()

        setContentView(R.layout.activity_main)

        iconBtn.setOnClickListener { openNextScreen() }
        log.d("Main activity created. Logger injected successfully")
        toast.show("Work Fine")
    }

    private fun inject() {
        MainActivityComponent.Initializer
                .init((applicationContext as App).getAppComponent())
                .inject(this@MainActivity)
    }

    private fun openNextScreen() {
        if (motionContainer.currentState == R.layout.activity_main_end) {
            motionContainer.transitionToStart()
        } else {
            motionContainer.transitionToEnd()
        }
    }

}
