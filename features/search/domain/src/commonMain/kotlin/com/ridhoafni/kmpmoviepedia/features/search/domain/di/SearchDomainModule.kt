package com.ridhoafni.kmpmoviepedia.features.search.domain.di

import com.ridhoafni.kmpmoviepedia.features.search.domain.useCases.SearchUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getSearchDomainModule(): Module {
    return module {
        factory{ SearchUseCase(get()) }
    }
}