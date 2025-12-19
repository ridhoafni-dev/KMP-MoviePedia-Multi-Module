package com.ridhoafni.kmpmoviepedia.features.details.domain.useCases

import com.ridhoafni.kmpmoviepedia.features.details.domain.repository.DetailsRepository

class GetMovieDetailsUseCases(
    private val detailsRepository: DetailsRepository
) {
    suspend fun execute(id: String) = detailsRepository.getMovieDetails(id)
}