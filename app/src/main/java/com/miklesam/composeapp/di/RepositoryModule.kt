package com.miklesam.composeapp.di

import com.miklesam.composeapp.network.RecipeDtoMapper
import com.miklesam.composeapp.network.RecipeService
import com.miklesam.composeapp.repository.RecipeRepository
import com.miklesam.composeapp.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            recipeService = recipeService,
            mapper = recipeDtoMapper
        )
    }

}