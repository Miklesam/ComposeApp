package com.miklesam.composeapp.network.responses

import com.google.gson.annotations.SerializedName
import com.miklesam.composeapp.network.RecipeDto

data class RecipeSearchResponse(
    @SerializedName("count")
    var count: Int,
    @SerializedName("results")
    var recipes: List<RecipeDto>
)