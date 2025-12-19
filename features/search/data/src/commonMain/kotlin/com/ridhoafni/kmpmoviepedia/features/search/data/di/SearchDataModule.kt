package com.ridhoafni.kmpmoviepedia.features.search.data.di

import com.ridhoafni.kmpmoviepedia.features.search.data.repository.SearchRepositoryImpl
import com.ridhoafni.kmpmoviepedia.features.search.domain.repository.SearchRepository
import org.koin.core.module.Module
import org.koin.dsl.module

fun getSearchDataModule(): Module {
    return module {
        single<SearchRepository> { SearchRepositoryImpl(get()) }
    }
}