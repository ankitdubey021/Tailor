package com.ankitdubey.tailor.di

import com.ankitdubey.tailor.core.api.TailorService
import com.ankitdubey.tailor.remote.TailorServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Ankit Dubey on 17,July,2021
 */

@InstallIn(SingletonComponent::class)
@Module
object NetworkingModule {

    @Singleton
    @Provides
    fun provideTailorService() : TailorService {
        return TailorServiceImpl()
    }

}