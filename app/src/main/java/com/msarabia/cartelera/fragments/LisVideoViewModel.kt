package com.msarabia.cartelera.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by msarabia on 5/29/21.
 */
class LisVideoViewModel : ViewModel() {

    // List of items of Videos
    private var _listVideosItems = MutableLiveData<String>()

    // readony list observable
    val listVideosItems : LiveData<String> = _listVideosItems

}