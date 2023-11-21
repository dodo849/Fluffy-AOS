package com.example.fluffy_aos.ui.post.reusable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.fluffy_aos.ui.common.Card
import com.example.fluffy_aos.ui.theme.gray_outline
import com.example.fluffy_aos.ui.theme.gray_text_light

@Composable
fun PostCard(title: String, detail: String, imageUrl: String = "") {
    val url =
        "https://www.shutterstock.com/image-photo/woman-running-dog-workout-during-600nw-2225043417.jpg"
    val painter = rememberAsyncImagePainter(url)

    Column(
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .size(120.dp)
                .background(Color.LightGray)
        )

        Column(
            modifier = Modifier
                .width(120.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
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