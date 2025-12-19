package com.ridhoafni.kmpmoviepedia.features.details.ui

import com.ridhoafni.kmpmoviepedia.features.details.domain.model.MovieDetails

data class DetailsUiState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: MovieDetails? = null
)
