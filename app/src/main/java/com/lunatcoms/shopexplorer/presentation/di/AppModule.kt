package com.lunatcoms.shopexplorer.presentation.di

import com.lunatcoms.shopexplorer.data.api.FortniteApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fortnite-api.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideFortniteApiService(retrofit: Retrofit): FortniteApiService{
        return retrofit.create(FortniteApiService::class.java)
    }
}