package com.example.fluffy_aos.ui.post.reusable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.fluffy_aos.model.post.Post
import com.example.fluffy_aos.ui.theme.gray_text_light

@Composable
fun PostCard(post: Post) {
    val painter = rememberAsyncImagePainter(post.imageUrl)

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
                post.title,
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                post.subTitle,
                fontSize = 14.sp,
                color = gray_text_light,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}