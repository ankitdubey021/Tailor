package com.ankitdubey.tailor.core.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

/**
 * Created by Ankit Dubey on 18,July,2021
 */


fun ImageView.loadImgUrl(path: String?, placeholder : Int) {
    Glide.with(this.context)
        .load(path)
        .placeholder(placeholder)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}

fun ImageView.loadImgUrl(path: String?) {
    Glide.with(this.context)
        .load(path)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}

fun ImageView.loadCircularImgUrl(path: String?) {
    Glide.with(this.context)
        .load(path)
        .transition(DrawableTransitionOptions.withCrossFade())
        .circleCrop()
        .into(this)
}