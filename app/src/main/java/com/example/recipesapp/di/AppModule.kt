package com.example.recipesapp.di

import com.example.recipesapp.data.repo.TariflerDaRepository
import com.example.recipesapp.retrofit.ApiUtils
import com.example.recipesapp.retrofit.TariflerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideTariflerDaRepository(tdao:TariflerDao): TariflerDaRepository{
     return TariflerDaRepository(tdao)
    }

    @Provides
    @Singleton
    fun provideTariflerDao(): TariflerDao{
        return ApiUtils.getTariflerDao()
    }
}