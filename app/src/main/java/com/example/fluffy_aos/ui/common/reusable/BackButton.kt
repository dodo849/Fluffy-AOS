package com.example.fluffy_aos.ui.common.reusable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.theme.gray_text_light

@Composable
fun BackButton() {
    val navController = LocalNavController.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { navController.navigateUp() }
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "뒤로가기", tint = gray_text_light
        )
        Text(
            text = "뒤로가기",
            modifier = Modifier.padding(start = 4.dp), color = gray_text_light
        )
    }
}