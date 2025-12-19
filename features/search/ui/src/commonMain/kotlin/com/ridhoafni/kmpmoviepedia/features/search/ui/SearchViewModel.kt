package com.ridhoafni.kmpmoviepedia.features.search.ui

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import com.ridhoafni.kmpmoviepedia.features.search.domain.useCases.SearchUseCase
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.update

@OptIn(FlowPreview::class)
class SearchViewModel(
    private val searchUseCase: SearchUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(viewModelScope, SearchUiState())

    @NativeCoroutinesState
    val uiState: StateFlow<SearchUiState> = _state

    private val _query = MutableStateFlow(viewModelScope, "")

    @NativeCoroutinesState
    val query: StateFlow<String> = _query

    fun updateQuery(q: String) {
        _query.update { q }
    }

    init {
        viewModelScope.launch {
            _query.filter { it.isNotEmpty() }
                .debounce { 500 }
                .distinctUntilChanged()
                .collectLatest { query ->
                    search(query)
                }
        }
    }

    private fun search(query: String) = viewModelScope.launch {
        _state.update { state ->
            state.copy(
                isLoading = true,
                error = "",
                data = null
            )
        }
        searchUseCase.invoke(query)
            .onSuccess { data ->
                _state.update { state ->
                    state.copy(
                        isLoading = false,
                        data = data,
                    )
                }
            }
            .onFailure { error ->
                _state.update { state ->
                    state.copy(
                        isLoading = false,
                        error = error.message ?: "Unknown error"
                    )
                }
            }
    }

}