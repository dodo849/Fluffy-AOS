package com.example.fluffy_aos.ui.post.reusable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.common.Card
import com.example.fluffy_aos.ui.theme.gray_text_light

@Composable
fun PostCard(title: String, detail: String) {
    Card {
        Column (
            modifier = Modifier.size(120.dp)
        ) {
            Text(
                title,
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                detail,
                fontSize = 14.sp,
                color = gray_text_light,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}