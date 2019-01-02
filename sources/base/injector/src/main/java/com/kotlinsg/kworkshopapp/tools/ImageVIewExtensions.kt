package com.kotlinsg.kworkshopapp.tools

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.showImage(image: String, options: RequestOptions = RequestOptions()) {
    Glide.with(context)
        .load(image)
        .apply(options)
        .into(this@showImage)
}

fun ImageView.showCircleImage(image: String, tempOptions: RequestOptions = RequestOptions()) {
    var options: RequestOptions = tempOptions
    options = options.circleCrop()
    Glide.with(context)
        .load(image)
        .apply(options)
        .into(this)
}