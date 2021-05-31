package com.msarabia.cartelera.helpers

/**
 * Created by msarabia on 5/29/21.
 */

const val MOVIES = 100
const val TV_SHOWS = 200

const val BASE_URL = "https://api.themoviedb.org/3/"
const val API_KEY = "ac6e5c83f7b6d8f25a1b8beaa55fe68f"
const val SECURE_IMAGE_PATH = "https://image.tmdb.org/t/p/"

const val TYPE_MOVIES = "movie"
const val TYPE_TVSHOW = "tv"


const val CATEGORY_POPULAR = "popular"
const val CATEGORY_TOP = "top_rated"
const val CATEGORY_UPCOMING = "upcoming"
const val CATEGORY_LATEST = "latest"

object Poster {
    const val SMALL = "w154"
    const val LITTLE_SMALL = "w185"
    const val MEDIUM = "w342"
    const val LARGE = "w500"
    const val EXTRA_LARGE = "w780"

    fun getImageSizeByCategory(category: String): String{
        return when(category){
            CATEGORY_POPULAR->  LITTLE_SMALL
            CATEGORY_LATEST ->  MEDIUM
            CATEGORY_TOP ->  LARGE
            CATEGORY_UPCOMING -> MEDIUM
            else -> LITTLE_SMALL
        }
    }
}


