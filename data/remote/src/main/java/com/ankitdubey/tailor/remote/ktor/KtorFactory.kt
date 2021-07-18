package com.ankitdubey.tailor.remote.ktor

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*

/**
 * Created by Ankit Dubey on 17,July,2021
 */

object KtorFactory {
    private const val TIME_OUT = 60000

    fun build(): HttpClient {
            return HttpClient(Android) {

                engine {
                    connectTimeout = TIME_OUT
                    socketTimeout = TIME_OUT
                }

                install(JsonFeature) {
                    serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    })
                }

                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            Log.v("Logger Ktor =>", message)
                        }

                    }
                    level = LogLevel.ALL
                }

                install(ResponseObserver) {
                    onResponse { response ->
                        Log.d("HTTP status:", "${response.status.value}")
                    }
                }

                install(DefaultRequest) {
                    header(HttpHeaders.ContentType, ContentType.Application.Json)
                }

                HttpResponseValidator {

                    validateResponse { response ->
                        val statusCode = response.status.value
                        when (statusCode) {
                            in 300..399 -> throw RedirectResponseException(response)
                            in 400..499 -> {
                                throw ClientRequestException(response)
                            }
                            in 500..599 -> throw ServerResponseException(response)
                        }
                        if (statusCode >= 600) {
                            throw ResponseException(response)
                        }
                    }
                }
            }


    }
}