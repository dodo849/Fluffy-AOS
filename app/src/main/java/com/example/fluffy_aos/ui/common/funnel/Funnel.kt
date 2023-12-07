package com.example.fluffy_aos.ui.common.funnel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.patrykandpatrick.vico.core.extension.setFieldValue

@Composable
fun Funnel(
    result: MutableMap<String, Any>,
    steps: List<Step>) {
    var currentStep by remember { mutableStateOf(steps[0].name) }

    steps.forEach { step ->
        if (currentStep == step.name) {
            step.content() { nextStep, input ->
                currentStep = nextStep ?: currentStep
                if (input != null) {
                    result[step.name] = input
                }
            }
        }
    }
}