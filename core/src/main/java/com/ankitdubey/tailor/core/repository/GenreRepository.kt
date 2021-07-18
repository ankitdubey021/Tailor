package com.ankitdubey.tailor.core.repository

import com.ankitdubey.tailor.core.model.Genre
import kotlinx.coroutines.flow.Flow

/**
 * Created by Ankit Dubey on 18,July,2021
 */
interface GenreRepository {
    fun genreList(): Flow<DataState<List<Genre>>>
}