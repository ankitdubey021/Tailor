package com.ankitdubey.tailor.core.repository

/**
 * Created by Ankit Dubey on 03,June,2021
 */

data class DataState<T>(
    val message: String? = null,
    val data: T? = null,
    val isLoading: Boolean = false
) {
    companion object {
        fun <T> error(
            message: String
        ): DataState<T> {
            return DataState<T>(message = message)
        }

        fun <T> data(
            data: T? = null
        ): DataState<T> {
            return DataState<T>(
                data = data
            )
        }

        fun <T> loading() = DataState<T>(isLoading = true)
    }
}