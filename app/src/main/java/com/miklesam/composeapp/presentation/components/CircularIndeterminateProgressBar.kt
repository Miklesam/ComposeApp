package com.miklesam.composeapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.WithConstraints
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun CircularIndeterminateProgressBar(
    isDisplayed: Boolean
) {
    if (isDisplayed) {

        WithConstraints(
            modifier = Modifier.fillMaxSize()
        ) {
            val constraints = if (minWidth < 600.dp) {
                myDecoupledConstrainets(0.3f)
            } else {
                myDecoupledConstrainets(0.7f)
            }

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize(),
                constraintSet = constraints
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.layoutId("progressBar"),
                    color = MaterialTheme.colors.primary
                )
                Text(
                    text = "Loading...",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = TextUnit.Companion.Sp(15)
                    ),
                    modifier = Modifier.layoutId("text"),
                )
            }

        }

    }
}

private fun myDecoupledConstrainets(verticalBias: Float): ConstraintSet {
    return ConstraintSet {
        val guidline = createGuidelineFromTop(verticalBias)
        val progressBar = createRefFor("progressBar")
        val text = createRefFor("text")

        constrain(progressBar) {
            top.linkTo(guidline)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(text) {
            top.linkTo(progressBar.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

    }
}