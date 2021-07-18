package com.ankitdubey.tailor.remote.model

import com.ankitdubey.tailor.core.model.Genre
import kotlinx.serialization.Serializable

/**
 * Created by Ankit Dubey on 18,July,2021
 */
@Serializable
data class GenreDto(
    val id : Int,
    val name : String
)

@Serializable
data class GenreDtoList(
    val genres : List<GenreDto>
)

fun GenreDto.toGenre() = Genre(id = id, name = name)

fun GenreDtoList.toGenreList() = genres.map { it.toGenre() }