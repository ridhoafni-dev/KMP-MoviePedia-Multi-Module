package com.ridhoafni.kmpmoviepedia.di

import com.ridhoafni.kmpmoviepedia.core.network.di.getCoreNetworkModule
import com.ridhoafni.kmpmoviepedia.features.details.data.repository.di.getDetailsDataModule
import com.ridhoafni.kmpmoviepedia.features.details.domain.di.getDetailsDomainModule
import com.ridhoafni.kmpmoviepedia.features.details.ui.di.getDetailsUiModule
import com.ridhoafni.kmpmoviepedia.features.search.data.di.getSearchDataModule
import com.ridhoafni.kmpmoviepedia.features.search.ui.di.getSearchUiModule
import com.ridhoafni.kmpmoviepedia.features.search.domain.di.getSearchDomainModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            getCoreNetworkModule(),
            getSearchUiModule(),
            getSearchDomainModule(),
            getSearchDataModule(),

            getDetailsUiModule(),
            getDetailsDomainModule(),
            getDetailsDataModule()
        )
    }
}