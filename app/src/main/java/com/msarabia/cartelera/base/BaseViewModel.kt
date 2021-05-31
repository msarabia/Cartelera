package com.msarabia.cartelera.base

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

open class BaseViewModel : ViewModel() {

    private var disposables = CompositeDisposable()

    fun <T> setupSubscribe(
        observable: Observable<T>,
        onSuccess: Consumer<T>,
        onError: Consumer<Throwable>? = null
    ) {
        disposables.add(
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    onSuccess,
                    onError ?: io.reactivex.functions.Consumer {
                        Log.d(
                            "setupSubscribe",
                            "Error no emitido para el observable"
                        )
                    })
        )


    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
        disposables.clear()
    }

}