package com.example.fluffy_aos.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.fluffy_aos.global.gray_background

@Composable
fun CardView(content: @Composable () -> Unit) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(10.dp))
        .background(gray_background)
        .padding(vertical = 10.dp, horizontal = 20.dp)
    ) {
        content()
    }
}