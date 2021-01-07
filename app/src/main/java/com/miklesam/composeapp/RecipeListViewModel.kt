package com.miklesam.composeapp

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.miklesam.composeapp.repository.RecipeRepository
import javax.inject.Named

class RecipeListViewModel
@ViewModelInject
constructor(
    private val randomString: String,
    private val repository: RecipeRepository,
    @Named("auth_token") private val token: String
) : ViewModel() {
    init {
        println("VIEWMODEL: $randomString")
        println("VIEWMODEL: $repository")
        println("VIEWMODEL: $token")
    }

    fun getRepo() = repository

    fun getRandomString() = randomString

    fun getToken() = token

}