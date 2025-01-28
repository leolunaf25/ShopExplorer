package com.lunatcoms.shopexplorer.presentation.di

import com.lunatcoms.shopexplorer.data.api.FortniteApiService
import com.lunatcoms.shopexplorer.data.repository.FortniteRepositoryImpl
import com.lunatcoms.shopexplorer.domain.repository.FortniteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    fun provideFortniteRepository(
        apiService: FortniteApiService
    ): FortniteRepository = FortniteRepositoryImpl(apiService)
}