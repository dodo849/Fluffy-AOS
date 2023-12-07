package com.example.fluffy_aos.ui.common.funnel

import androidx.compose.runtime.Composable

class Step(
    val name: String,
    val content: @Composable (callback: (nextStep: String?) -> Unit) -> Unit,
) {

}
