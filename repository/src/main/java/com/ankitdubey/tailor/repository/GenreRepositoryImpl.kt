package com.ankitdubey.tailor.repository

import com.ankitdubey.tailor.core.api.TailorService
import com.ankitdubey.tailor.core.model.Genre
import com.ankitdubey.tailor.core.repository.DataState
import com.ankitdubey.tailor.core.repository.GenreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ankit Dubey on 18,July,2021
 */
@Singleton
class GenreRepositoryImpl @Inject constructor(
    private val tailorService: TailorService
) : GenreRepository {
    override fun genreList(): Flow<DataState<List<Genre>>> = flow {
        emit(DataState.loading())

        try {

            val res = tailorService.genreList()
            emit(DataState.data(res))

        } catch (ex: Exception) {
            emit(DataState.error<List<Genre>>(ex.message ?: "Unknown error"))
        }
    }
}