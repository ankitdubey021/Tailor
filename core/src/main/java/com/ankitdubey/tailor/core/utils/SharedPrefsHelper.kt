package com.ankitdubey.tailor.core.utils

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ankit Dubey on 17,June,2021
 */

@Singleton
class SharedPrefsHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    companion object {
        const val SHARED_PREF_FILE_NAME = "tailer_prefs"
    }

    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }

    fun clear(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    fun put(key: String, value: String?) {
        if (value == null) return
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun put(key: String, value: Long?) {
        if (value == null) return
        sharedPreferences.edit().putLong(key, value).apply()
    }

    fun put(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun getString(key: String, defaultValue: String? = null) =
        sharedPreferences.getString(key, defaultValue)

    fun getLong(key: String, defaultValue: Long = 0) =
        sharedPreferences.getLong(key, defaultValue)

}