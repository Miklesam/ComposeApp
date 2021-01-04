package com.miklesam.composeapp.network

import com.miklesam.composeapp.domain.Recipe
import com.miklesam.composeapp.domain.util.EntityMapper

class RecipeNetworkMapper : EntityMapper<RecipeNetworkEntity, Recipe> {
    override fun mapFromEntity(entity: RecipeNetworkEntity): Recipe {
        return Recipe(
            id = entity.pk,
            title = entity.title,
            publisher = entity.publisher,
            featuredImage = entity.featuredImage,
            rating = entity.rating,
            description = entity.description,
            cookingInstructions = entity.cookingInstructions,
            ingredients = entity.ingredients ?: listOf(),
            dateAdded = entity.dateAdded,
            dateUpdated = entity.dateUpdated
        )
    }

    override fun mapToEntity(domainModule: Recipe): RecipeNetworkEntity {
        return RecipeNetworkEntity(
            pk = domainModule.id,
            title = domainModule.title,
            publisher = domainModule.publisher,
            featuredImage = domainModule.featuredImage,
            rating = domainModule.rating,
            description = domainModule.description,
            cookingInstructions = domainModule.cookingInstructions,
            ingredients = domainModule.ingredients,
            dateAdded = domainModule.dateAdded,
            dateUpdated = domainModule.dateUpdated
        )
    }

    fun fromEntityList(initial: List<RecipeNetworkEntity>): List<Recipe> {
        return initial.map { mapFromEntity(it) }
    }

    fun toEntityList(initial: List<Recipe>): List<RecipeNetworkEntity> {
        return initial.map { mapToEntity(it) }
    }

}