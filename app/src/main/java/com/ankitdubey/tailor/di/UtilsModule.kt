package com.ankitdubey.tailor.di

import android.content.Context
import android.content.SharedPreferences
import com.ankitdubey.tailor.core.utils.SharedPrefsHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Ankit Dubey on 17,June,2021
 */

@InstallIn(SingletonComponent::class)
@Module
object UtilsModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext appContext: Context): SharedPreferences {
        return appContext.getSharedPreferences(SharedPrefsHelper.SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)
    }
}