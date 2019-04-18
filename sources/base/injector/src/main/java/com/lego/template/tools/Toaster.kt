package com.lego.template.tools

import android.content.Context
import android.widget.Toast

class ToasterImpl constructor(
        private val appContext: Context
) : Toaster {
    override fun show(msg: String) {
        Toast.makeText(appContext, msg, Toast.LENGTH_SHORT).show()
    }
}