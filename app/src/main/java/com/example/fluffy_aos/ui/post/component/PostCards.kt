package com.example.fluffy_aos.ui.post.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.model.PostsByCategory
import com.example.fluffy_aos.ui.post.reusable.PostCard

@Composable
fun PostCards(postsByCategories: List<PostsByCategory>) {
    postsByCategories.forEach {
        PostCardsRow(it)
    }
}

@Composable 
internal fun PostCardsRow(postsByCategory: PostsByCategory) {
    Column {
        Row {
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            Text(
                postsByCategory.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .padding(20.dp)
                .horizontalScroll(rememberScrollState())
                .fillMaxSize(),
        ) {
            postsByCategory.posts.forEach {
                PostCard(it)
            }
        }
    }
}