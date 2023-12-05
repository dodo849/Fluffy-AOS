package com.example.fluffy_aos.funnel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Funnel(
    survey: MutableMap<String, Any>,
    steps: List<Step>) {
    var currentStep by remember { mutableStateOf(steps[0].name) }

    steps.forEach { step ->
        if (currentStep == step.name) {
            step.content() { nextStep, input ->
                currentStep = nextStep ?: currentStep
                survey[step.name] = input ?: ""
            }
        }
    }
}