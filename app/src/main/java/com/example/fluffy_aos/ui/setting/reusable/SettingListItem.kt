package com.example.fluffy_aos.ui.setting.reusable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.theme.gray_text_light

@Composable
fun SettingListItem(
    title: String,
    destinationPageName: String
) {
    val navController = LocalNavController.current

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable(onClick = {
                navController.navigate(destinationPageName)
            })
    ) {
        Text(
            title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
        Icon(
            imageVector = Icons.Default.ArrowForward, // 화살표 아이콘
            contentDescription = null,
            tint = gray_text_light, // 화살표 아이콘 색상
            modifier = Modifier
                .size(24.dp)
        )
    }
}