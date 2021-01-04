package com.miklesam.composeapp.repository

import com.miklesam.composeapp.domain.Recipe
import com.miklesam.composeapp.domain.util.DomainMapper
import com.miklesam.composeapp.network.RecipeDto
import com.miklesam.composeapp.network.RecipeDtoMapper
import com.miklesam.composeapp.network.RecipeService

class RecipeRepositoryImpl(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
) : RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token, page, query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token, id))
    }

}