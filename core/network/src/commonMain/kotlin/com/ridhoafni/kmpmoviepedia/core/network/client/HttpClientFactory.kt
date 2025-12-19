package com.ridhoafni.kmpmoviepedia.core.network.client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HttpClientFactory {
    fun getInstance(): HttpClient {
        return HttpClient {
            install(ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true })
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("HTTP Client: $message")
                    }
                }
                level = LogLevel.ALL
            }

            install(HttpTimeout) {
                socketTimeoutMillis = 20_000L
                requestTimeoutMillis = 20_000L
            }

            // https://api.themoviedb.org/3/search/movie?query=harry&include_adult=false&language=en-US&page=1
            // Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2MWVhZTUwNDRmMTQwNDJiYWI1NTUzZGE5MzU4ZDc3MSIsIm5iZiI6MTU3MjY3MDIzNC44MTMsInN1YiI6IjVkYmQwYjFhOTYzODY0MDAxMmUwYWNkYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.vSLYdYbSgM5AVVGKMQnWJ_V2PumuGs-0e_hsn4jcR_I'
            install(DefaultRequest) {
                url {
                    host = "api.themoviedb.org"
                    protocol = URLProtocol.HTTPS
                }
                header(
                    HttpHeaders.Authorization,
                    "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2MWVhZTUwNDRmMTQwNDJiYWI1NTUzZGE5MzU4ZDc3MSIsIm5iZiI6MTU3MjY3MDIzNC44MTMsInN1YiI6IjVkYmQwYjFhOTYzODY0MDAxMmUwYWNkYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.vSLYdYbSgM5AVVGKMQnWJ_V2PumuGs-0e_hsn4jcR_I"
                )

            }
        }
    }
}