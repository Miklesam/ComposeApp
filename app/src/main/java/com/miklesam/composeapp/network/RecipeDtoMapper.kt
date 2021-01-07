package com.miklesam.composeapp.network

import com.miklesam.composeapp.domain.Recipe
import com.miklesam.composeapp.domain.util.DomainMapper

class RecipeDtoMapper : DomainMapper<RecipeDto, Recipe> {
    override fun mapToDomainModel(model: RecipeDto): Recipe {
        return Recipe(
            id = model.pk,
            title = model.title,
            publisher = model.publisher,
            featuredImage = model.featuredImage,
            rating = model.rating,
            description = model.description,
            cookingInstructions = model.cookingInstructions,
            ingredients = model.ingredients.orEmpty(),
            dateAdded = model.dateAdded,
            dateUpdated = model.dateUpdated
        )
    }

    override fun mapFromDomainModel(domainModule: Recipe): RecipeDto {
        return RecipeDto(
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

    fun toDomainList(initial: List<RecipeDto>): List<Recipe> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Recipe>): List<RecipeDto> {
        return initial.map { mapFromDomainModel(it) }
    }

}