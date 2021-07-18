package com.ankitdubey.tailor.di

import com.ankitdubey.tailor.core.api.TailorService
import com.ankitdubey.tailor.core.repository.GenreRepository
import com.ankitdubey.tailor.core.repository.MovieRepository
import com.ankitdubey.tailor.repository.GenreRepositoryImpl
import com.ankitdubey.tailor.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Ankit Dubey on 18,July,2021
 */

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(tailorService: TailorService): MovieRepository {
        return MovieRepositoryImpl(tailorService)
    }

    @Singleton
    @Provides
    fun provideGenreRepository(tailorService: TailorService): GenreRepository {
        return GenreRepositoryImpl(tailorService)
    }

}