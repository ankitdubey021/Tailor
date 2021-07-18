package com.ankitdubey.tailor.core.repository

import com.ankitdubey.tailor.core.model.Movie
import kotlinx.coroutines.flow.Flow

/**
 * Created by Ankit Dubey on 18,July,2021
 */
interface MovieRepository {
    fun popularMovies() : Flow<DataState<List<Movie>>>
}