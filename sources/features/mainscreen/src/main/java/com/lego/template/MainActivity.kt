package com.lego.template

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lego.template.di.Logger
import com.lego.template.mainscreen.R
import com.lego.template.tools.Toaster
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val log: Logger by inject()
    private val toast: Toaster by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        iconBtn.setOnClickListener { openNextScreen() }
        log.d("Main activity created. Logger injected successfully")
        toast.show("Work Fine")
    }

    private fun openNextScreen() {
        if (motionContainer.currentState == R.layout.activity_main_end) {
            motionContainer.transitionToStart()
        } else {
            motionContainer.transitionToEnd()
        }
    }

}
