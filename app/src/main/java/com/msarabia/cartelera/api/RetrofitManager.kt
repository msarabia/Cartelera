package com.msarabia.cartelera.api

import com.google.gson.Gson
import com.msarabia.cartelera.helpers.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by msarabia on 5/29/21.
 */
object RetrofitManager {
    const val headerContentType = "Content-Type: application/json"
    const val headerConnection = "Connection: close"

    private var level: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY
    private var retrofit: Retrofit? = null
    private const val connectTimeoutInSeconds = 60L
    private const val readTimeoutInSeconds = 60L
    private const val followRedirects = false

    private var gson = Gson()
    private val loggingInterceptor: HttpLoggingInterceptor
        get() {
            val logging = HttpLoggingInterceptor()
            logging.level = level
            return logging
        }


    private val okHttpClientBuilder: OkHttpClient.Builder
        get() {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BASIC
            return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(logging)
                .connectTimeout(connectTimeoutInSeconds, TimeUnit.SECONDS)
                .readTimeout(readTimeoutInSeconds, TimeUnit.SECONDS)
                .followRedirects(followRedirects)
        }

    private fun instance(): Retrofit {
        if (retrofit != null) return retrofit!!

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit!!
    }

    fun <T> getService(service: Class<T>): T {
        return instance().create(service)
    }
}