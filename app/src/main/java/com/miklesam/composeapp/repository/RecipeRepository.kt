package com.miklesam.composeapp.repository

import com.miklesam.composeapp.domain.Recipe

interface RecipeRepository {

    suspend fun search(token: String, page: Int, query: String): List<Recipe>

    suspend fun get(token: String, id: Int): Recipe

}