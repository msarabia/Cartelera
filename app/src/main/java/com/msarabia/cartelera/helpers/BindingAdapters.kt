package com.msarabia.cartelera.helpers

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

/***
 * Helper bindings
 */
object BindingAdapters {
    @BindingAdapter("loadImage","error")
    @JvmStatic
    fun loadImage(container: ImageView, url:String, errorImage:Drawable){
        val picasso =
            Picasso.get().load(url).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)

        if (!Network.isNetworkAvailable( container.context)) {
            picasso.networkPolicy(NetworkPolicy.OFFLINE)
        }
        picasso.error(errorImage).into(container)
    }

}