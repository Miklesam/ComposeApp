package com.miklesam.composeapp

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class RecipeListViewModel
    @ViewModelInject
    constructor(
        private val randomString:String
    ):ViewModel(){
    init {
        println("VIEWMODEL: $randomString")
    }
}