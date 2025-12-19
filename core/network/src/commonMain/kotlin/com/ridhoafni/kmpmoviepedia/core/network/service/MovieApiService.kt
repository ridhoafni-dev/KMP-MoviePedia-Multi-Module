package com.ridhoafni.kmpmoviepedia.core.network.service

import com.ridhoafni.kmpmoviepedia.core.network.model.details.MovieDetailsResponse
import com.ridhoafni.kmpmoviepedia.core.network.model.search.MovieDTO
import com.ridhoafni.kmpmoviepedia.core.network.model.search.SearchResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MovieApiService(
    private val client: HttpClient
) {
    //"https://api.themoviedb.org/3/search/movie"
    suspend fun searchMovies(query: String): Result<List<MovieDTO>> {
        return try {
            val response = client.get("3/search/movie") {
                parameter("query", query)
            }.body<SearchResponse>()

            Result.success(response.results ?: emptyList())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    //"https://api.themoviedb.org/3/search/movie/{movie_id}"
    suspend fun getMovieDetails(id: String): Result<MovieDetailsResponse> {
        return try {
            val response = client.get("3/movie/$id").body<MovieDetailsResponse>()
            Result.success(response)
        }catch (e: Exception) {
            Result.failure(e)
        }
    }

}