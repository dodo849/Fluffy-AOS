package com.example.fluffy_aos.ui.common.funnel

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.patrykandpatrick.vico.core.extension.setFieldValue

@Composable
fun Funnel(
    steps: List<Step>
) {
    var currentStep by rememberSaveable { mutableStateOf(steps[0].name) }

    Crossfade(
        targetState = currentStep, animationSpec = tween(durationMillis = 500),
        label = ""
    ) { targetStep ->
        steps.firstOrNull { it.name == targetStep }?.content?.let {
            it() { nextStep ->
                currentStep = nextStep ?: currentStep
            }
        }
    }
}