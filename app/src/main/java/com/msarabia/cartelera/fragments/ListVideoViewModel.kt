package com.msarabia.cartelera.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.msarabia.cartelera.api.RetrofitManager
import com.msarabia.cartelera.api.services.MoviesServices
import com.msarabia.cartelera.base.BaseViewModel
import com.msarabia.cartelera.data.models.MediaListModel

class ListVideoViewModel (val type: String, val category: String)  : BaseViewModel() {
    var service: MoviesServices = RetrofitManager.getService(MoviesServices::class.java)

    // List of items of Videos and readony list observable
    private val _listVideosItems : MutableLiveData<MediaListModel> by lazy {
        MutableLiveData<MediaListModel>().also { getListResources() }
    }
    val listVideosItems: LiveData<MediaListModel> = _listVideosItems

    private var _onError = MutableLiveData<Boolean>()
    val onError: LiveData<Boolean> = _onError


    private fun getListResources() {
        setupSubscribe(service.getListMedia(type, category),{
            _listVideosItems.value = it
        },{
            _onError.value = true
        })
    }


}

class ListVideoViewModelFactory(private val type: String, private val category: String) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListVideoViewModel(type, category) as T
    }
}
