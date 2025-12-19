package com.ridhoafni.kmpmoviepedia.features.details.ui.di

import com.ridhoafni.kmpmoviepedia.features.details.ui.DetailsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

actual fun getDetailsUiModule(): org.koin.core.module.Module {
    return module {
        viewModel {
            DetailsViewModel(get())
        }
    }
}