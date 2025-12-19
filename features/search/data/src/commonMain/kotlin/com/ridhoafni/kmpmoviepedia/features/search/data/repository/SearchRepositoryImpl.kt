package com.ridhoafni.kmpmoviepedia.features.search.data.repository

import com.ridhoafni.kmpmoviepedia.core.network.service.MovieApiService
import com.ridhoafni.kmpmoviepedia.features.search.domain.model.Movie
import com.ridhoafni.kmpmoviepedia.features.search.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val service: MovieApiService
): SearchRepository {
    override suspend fun search(q: String): Result<List<Movie>> {
        return service.searchMovies(q).map { list ->
            list.map { dto ->
                Movie(
                    id = dto.id.toString(),
                    title = dto.title ?: "",
                    imageUrl = buildImageUrl(dto.posterPath ?: ""),
                )
            }
        }
    }

    private fun buildImageUrl(path: String): String {
        if (path.isEmpty()) return ""
        return "https://image.tmdb.org/t/p/original$path"
    }
}