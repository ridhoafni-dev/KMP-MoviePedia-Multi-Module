package com.ridhoafni.kmpmoviepedia.features.details.data.repository.di

import com.ridhoafni.kmpmoviepedia.features.details.data.repository.DetailsRepositoryImpl
import com.ridhoafni.kmpmoviepedia.features.details.domain.repository.DetailsRepository
import org.koin.dsl.module

fun getDetailsDataModule() = module {
    single<DetailsRepository> {
        DetailsRepositoryImpl(get())
    }
}