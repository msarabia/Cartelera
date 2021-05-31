package com.msarabia.cartelera.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class MediaListModel(
    val page: Int,
    val results: List<MediaInfo>,
    val total_pages: Int?,
    val total_results: Int?
)

@Parcelize
data class MediaInfo(
    val backdrop_path: String?,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val vote_average: Double?,
    val vote_count: Int?,
    val original_title: String?,
    val original_name: String?,


//    val release_date: String,

//    val title: String,
//    val video: Boolean,
//    val adult: Boolean,

):Parcelable {
    val getTitle:String
            get() {
                return (original_title?: original_name) as String
            }

    val getBackDrop:String
        get() {
            return (backdrop_path?: getPosterPath) as String
        }

    val getPosterPath:String
        get() {
            return (poster_path?: "") as String
        }
}



