package com.ankitdubey.tailor.remote.model

import com.ankitdubey.tailor.core.model.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Ankit Dubey on 17,July,2021
 */

@Serializable
data class MovieDtoList(
    val page: Int,
    val results: List<MovieDto>
)

@Serializable
data class MovieDto(
    val id: Long,
    @SerialName("original_title")
    val originalTitle: String,
    val overview: String,

    val vote_count: Int,
    val vote_average: Double,
    val release_date: String? = null,
    val poster_path: String,
    val backdrop_path: String? = null,
    val genre_ids: List<Int>
)

fun MovieDto.toMovie(): Movie {
    return Movie(
        id = id,
        originalTitle = originalTitle,
        overview = overview,
        voteCount = vote_count,
        voteAverage = vote_average,
        releaseDate = release_date,
        posterPath = poster_path,
        backdropPath = backdrop_path,
        genreIds = genre_ids
    )
}

fun MovieDtoList.toMovieList() = results.map { it.toMovie() }