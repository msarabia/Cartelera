package com.msarabia.cartelera.helpers

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

/***
 * Helper bindings
 */
object BindingAdapters {
    @BindingAdapter("loadImage", "imageSize")
    @JvmStatic
    fun loadImage(container: ImageView, url: String, size: String) {
        if (url.isNullOrEmpty() || size.isNullOrEmpty()) return

        val strUrl = String.format(SECURE_IMAGE_PATH + "%s" + url, size)
        val picasso =
            Picasso.get().load(strUrl)

        if (!Network.isNetworkAvailable(container.context)) {
            picasso.networkPolicy(NetworkPolicy.OFFLINE)
        }
        picasso.into(container)
//        picasso.error(errorImage).into(container)
    }

}