package com.ankitdubey.tailor.core.model

/**
 * Created by Ankit Dubey on 17,July,2021
 */
data class Movie(
    val id: Long,
    val originalTitle: String,
    val overview: String,
    val voteCount : Int,
    val voteAverage : Double,
    val releaseDate : String?,
    val posterPath : String,
    val backdropPath : String?,
    val genreIds : List<Int>
)