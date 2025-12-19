package com.ridhoafni.kmpmoviepedia.features.details.ui

import com.rickclephas.kmp.nativecoroutines.NativeCoroutineScope
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import com.ridhoafni.kmpmoviepedia.features.details.domain.useCases.GetMovieDetailsUseCases
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class DetailsViewModel(
    private val detailsUseCases: GetMovieDetailsUseCases
) : ViewModel() {
    private val _uiState = MutableStateFlow(viewModelScope, DetailsUiState())
    @NativeCoroutineScope
    val uiState: StateFlow<DetailsUiState> = _uiState

    fun getMovies(id: String) = viewModelScope.launch {
        _uiState.update {
            DetailsUiState(isLoading = true)
        }

        detailsUseCases.execute(id)
            .onSuccess { data ->
                _uiState.update {
                    DetailsUiState(data = data)
                }
            }
            .onFailure { error ->
                _uiState.update {
                    DetailsUiState(error = error.message ?: "Unknown error")
                }
            }
    }


}