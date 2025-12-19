package com.ridhoafni.kmpmoviepedia.features.search.domain.useCases

import com.ridhoafni.kmpmoviepedia.features.search.domain.repository.SearchRepository

class SearchUseCase(private val searchRepository: SearchRepository) {
    suspend fun invoke(q: String) = searchRepository.search(q)
}