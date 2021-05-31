package com.msarabia.cartelera.data.models

data class Configuration(
    val change_keys: List<String>,
    val images: Images
)

data class Images(
    val backdrop_sizes: List<String>,
    val base_url: String,
    val logo_sizes: List<String>,
    val poster_sizes: List<String>,
    val profile_sizes: List<String>,
    val secure_base_url: String,
    val still_sizes: List<String>
)