package com.ridhoafni.kmpmoviepedia.features.details.domain.repository

import com.ridhoafni.kmpmoviepedia.features.details.domain.model.MovieDetails

interface DetailsRepository {
    suspend fun getMovieDetails(id: String): Result<MovieDetails>
}