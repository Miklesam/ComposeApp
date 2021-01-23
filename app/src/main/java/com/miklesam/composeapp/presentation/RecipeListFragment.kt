package com.miklesam.composeapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.miklesam.composeapp.RecipeApplication
import com.miklesam.composeapp.presentation.components.*
import com.miklesam.composeapp.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import java.security.Key
import javax.inject.Inject

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    @Inject

    lateinit var application: RecipeApplication

    val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                AppTheme(darkTheme = application.isDark.value) {
                    val recipes = viewModel.recipes.value

                    val query = viewModel.query.value

                    val selectedCategory = viewModel.selectedCategory.value

                    val loading = viewModel.loading.value
                    Column {
                        SearchAppBar(
                            query = query,
                            onQueryChanged = viewModel::onQueryChanged,
                            onExecuteSearch = viewModel::newSearch,
                            scrollPosition = viewModel.categoryScrollPosition,
                            selectedCategory = selectedCategory,
                            onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                            onChangeCategoryScrollPosition = viewModel::onChangeCategoryScrollPosition,
                            onToggleTheme = {
                                application.toggleLightTheme()
                            }
                        )
                        val state =
                            remember { mutableStateOf(HeartAnimationDefinition.HeartButtonState.IDLE) }


                        //LoadingRecipeListShimmer(imageHeight = 250.dp)
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    color = MaterialTheme.colors.background
                                )
                        ) {
                            if (loading) {
                                LoadingRecipeListShimmer(imageHeight = 250.dp)
                            } else {
                                LazyColumn {
                                    itemsIndexed(
                                        items = recipes
                                    ) { index, recipe ->
                                        RecipeCard(recipe = recipe, onClick = {})
                                    }
                                }
                            }
                            CircularIndeterminateProgressBar(isDisplayed = loading)
                        }
                    }
                }


            }
        }
    }


}
