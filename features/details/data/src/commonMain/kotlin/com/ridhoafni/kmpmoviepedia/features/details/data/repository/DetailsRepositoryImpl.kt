package com.ridhoafni.kmpmoviepedia.features.details.data.repository

import com.ridhoafni.kmpmoviepedia.core.network.service.MovieApiService
import com.ridhoafni.kmpmoviepedia.features.details.domain.model.MovieDetails
import com.ridhoafni.kmpmoviepedia.features.details.domain.repository.DetailsRepository

class DetailsRepositoryImpl(
    private val movieApiService: MovieApiService
): DetailsRepository {
    override suspend fun getMovieDetails(id: String): Result<MovieDetails> {
        return movieApiService.getMovieDetails(id)
            .map { data ->
                MovieDetails(
                    id = data.id.toString(),
                    title = data.title ?: "",
                    overview = data.overview ?: "",
                    imageUrl = buildImageUrl(data.posterPath ?: "")
                )
            }
    }

    private fun buildImageUrl(path: String): String {
        if (path.isEmpty()) return ""
        return "https://image.tmdb.org/t/p/original$path"
    }
}