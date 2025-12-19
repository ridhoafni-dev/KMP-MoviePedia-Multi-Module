package com.ridhoafni.kmpmoviepedia.features.details.domain.di

import com.ridhoafni.kmpmoviepedia.features.details.domain.useCases.GetMovieDetailsUseCases
import org.koin.dsl.module

fun getDetailsDomainModule() = module {
    factory {
        GetMovieDetailsUseCases(get())
    }
}