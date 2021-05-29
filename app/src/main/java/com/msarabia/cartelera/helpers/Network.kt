package com.msarabia.cartelera.helpers

import android.content.Context
import android.net.ConnectivityManager

/***
 * Helper to get network status
 */
object Network {
    @JvmStatic
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}