package com.ridhoafni.kmpmoviepedia.features.search.ui

import com.ridhoafni.kmpmoviepedia.features.search.domain.model.Movie

data class SearchUiState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<Movie>? = null
)
