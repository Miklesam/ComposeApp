package com.miklesam.composeapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp


@Composable
fun ShimmerRecipeCardItem(
    colors: List<Color>,
    cardHeight: Dp,
    xShimmer: Float,
    yShimmer: Float,
    padding: Dp
) {
    val brush = Brush.linearGradient(
        colors,
        start = Offset(xShimmer - 100f, yShimmer - 100f),
        end = Offset(xShimmer, yShimmer)
    )
    Column(
        modifier = Modifier
            .padding(padding)
    ) {
        Surface(shape = MaterialTheme.shapes.small) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .preferredHeight(cardHeight)
                    .background(brush = brush)
            )
        }
    }

}
