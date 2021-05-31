package com.msarabia.cartelera.api.services

import com.msarabia.cartelera.data.models.Configuration
import com.msarabia.cartelera.data.models.MediaListModel
import com.msarabia.cartelera.helpers.API_KEY
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesServices {

//    @GET("/3/configuration")
//    fun getConfiguracion(@Query("api_key") api_key:String= API_KEY) : Observable<Configuration>
//
//
//    @GET("/3/movies/popular")
//    fun getPopularMovies(@Query("api_key") api_key:String= API_KEY) : Observable<MediaListModel>
//
//    @GET("/3/tv/popular")
//    fun getPopularTv(@Query("api_key") api_key:String= API_KEY) : Observable<MediaListModel>

    @GET("/3/{type}/{category}")
    fun getListMedia(
        @Path("type") type:String,
        @Path("category") category:String,
        @Query("api_key") api_key:String= API_KEY,
        @Query("language") language:String= "es") : Observable<MediaListModel>

}