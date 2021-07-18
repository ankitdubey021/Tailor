package com.ankitdubey.tailor.remote

import com.ankitdubey.tailor.core.api.TailorService
import com.ankitdubey.tailor.core.model.Genre
import com.ankitdubey.tailor.core.model.Movie
import com.ankitdubey.tailor.remote.ktor.KtorFactory
import com.ankitdubey.tailor.remote.model.*
import io.ktor.client.request.*
import javax.inject.Singleton

/**
 * Created by Ankit Dubey on 17,July,2021
 */

@Singleton
class TailorServiceImpl : TailorService {
    override suspend fun popularMovies(): List<Movie> {
        val mUrl = "movie/popular"

        val client = KtorFactory.build()
        val res = client.get<MovieDtoList>("$BASE_URL$mUrl") {
            parameter(API_KEY_STR, API_KEY)
            parameter(LANGUAGE_STR, LANGUAGE)
            parameter(PAGE_STR, "1")
        }

        return res.toMovieList()
    }

    override suspend fun genreList(): List<Genre> {
        val mUrl = "genre/movie/list"

        val client = KtorFactory.build()
        val res = client.get<GenreDtoList>("$BASE_URL$mUrl") {
            parameter(API_KEY_STR, API_KEY)
            parameter(LANGUAGE_STR, LANGUAGE)
        }
        return res.toGenreList()
    }
}