package com.miklesam.composeapp.presentation.util

import androidx.compose.animation.core.*
import com.miklesam.composeapp.presentation.util.ShimmerAnimationDefinitions.AnimationState.*

class ShimmerAnimationDefinitions(
    private val widthPx: Float,
    private val heightPx: Float,
    private val gradientWidth: Float
) {

    enum class AnimationState {
        START, END
    }

    val xShimerPropKey = FloatPropKey("xShimmer")
    val yShimerPropKey = FloatPropKey("yShimmer")

    val shimmerTransitionDefinition = transitionDefinition<AnimationState> {
        state(START) {
            this[xShimerPropKey] = 0f
            this[yShimerPropKey] = 0f
        }
        state(END) {
            this[xShimerPropKey] = widthPx + gradientWidth
            this[yShimerPropKey] = heightPx + gradientWidth
        }
        transition(START, END) {
            xShimerPropKey using infiniteRepeatable(
                animation = tween(
                    durationMillis = 1300,
                    delayMillis = 300,
                    easing = LinearEasing
                ),
            )
            yShimerPropKey using infiniteRepeatable(
                animation = tween(
                    durationMillis = 1300,
                    delayMillis = 300,
                    easing = LinearEasing
                ),
            )
        }

    }
}