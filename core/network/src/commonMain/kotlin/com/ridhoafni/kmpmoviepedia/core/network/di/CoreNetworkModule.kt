package com.ridhoafni.kmpmoviepedia.core.network.di

import com.ridhoafni.kmpmoviepedia.core.network.client.HttpClientFactory
import com.ridhoafni.kmpmoviepedia.core.network.service.MovieApiService
import org.koin.core.module.Module
import org.koin.dsl.module

fun getCoreNetworkModule(): Module {
    return module {
        single { MovieApiService(HttpClientFactory.getInstance()) }
    }
}