package com.example.fluffy_aos.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fluffy_aos.ui.theme.gray_background

@Composable
fun CardView(
    backgroundColor: Color = gray_background,
    content: @Composable () -> Unit
) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(20.dp))
        .background(backgroundColor)
        .padding(vertical = 30.dp, horizontal = 25.dp)
    ) {
        content()
    }
}