package com.hing.publicrepositories.extensions

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Created by Hung Luong on 8/31/2020.
 */
fun ImageView.loadCircleImage(@DrawableRes defaultImage: Int) {
    Glide.with(this.context).load(defaultImage).apply(RequestOptions.circleCropTransform())
        .into(this)
}

fun ImageView.loadCircleImageURL(url: String?, @DrawableRes defaultImage: Int) {
    if (url.isNullOrEmpty()) {
        this.loadCircleImage(defaultImage)
    } else {
        Glide.with(this.context)
            .asDrawable()
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .error(
                Glide.with(this.context).load(defaultImage)
                    .apply(RequestOptions.circleCropTransform())
            )
            .into(this)
    }
}
