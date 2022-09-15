package com.ersinberkealemdaroglu.rickandmortyapp.utils

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

fun ImageView.downloadFromUrl(image : String){
    image.let {
        //val imgUri = image.toUri().buildUpon().scheme("https").build()
        Glide.with(context)
            .load(image)
            .into(this)
    }
}

@BindingAdapter("android:downloadImageUrl")
fun downloadImage(view: ImageView, image: String){
    view.downloadFromUrl(image)
}