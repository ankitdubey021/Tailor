package com.ankitdubey.tailor.core.api

import com.ankitdubey.tailor.core.model.Genre
import com.ankitdubey.tailor.core.model.Movie
import com.ankitdubey.tailor.core.repository.DataState
import kotlinx.coroutines.flow.Flow

/**
 * Created by Ankit Dubey on 17,July,2021
 */
interface TailorService {
    suspend fun popularMovies() : List<Movie>
    suspend fun genreList() : List<Genre>
}