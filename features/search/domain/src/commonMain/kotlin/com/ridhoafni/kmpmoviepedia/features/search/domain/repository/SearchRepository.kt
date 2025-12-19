package com.ridhoafni.kmpmoviepedia.features.search.domain.repository

import com.ridhoafni.kmpmoviepedia.features.search.domain.model.Movie

interface SearchRepository {
    suspend fun search(q: String): Result<List<Movie>>
}