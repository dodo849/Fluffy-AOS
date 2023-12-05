package com.example.fluffy_aos.funnel

import androidx.compose.runtime.Composable

class Step(
    val name: String,
    val content: @Composable (callback: (nextStep: String?, input: Any?) -> Unit) -> Unit,
) {

}
