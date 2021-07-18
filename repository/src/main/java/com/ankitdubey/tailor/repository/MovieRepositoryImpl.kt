package com.ankitdubey.tailor.repository

import com.ankitdubey.tailor.core.api.TailorService
import com.ankitdubey.tailor.core.model.Movie
import com.ankitdubey.tailor.core.repository.DataState
import com.ankitdubey.tailor.core.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ankit Dubey on 18,July,2021
 */

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val tailorService: TailorService
) : MovieRepository {
    override fun popularMovies(): Flow<DataState<List<Movie>>> = flow {
        emit(DataState.loading())

        try {

            val res = tailorService.popularMovies()
            emit(DataState.data(res))

        } catch (ex: Exception) {
            emit(DataState.error<List<Movie>>(ex.message ?: "Unknown error"))
        }
    }
}