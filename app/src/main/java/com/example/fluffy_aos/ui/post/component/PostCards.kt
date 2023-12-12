package com.example.fluffy_aos.ui.post.component

import androidx.compose.foundation.clickable
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
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.model.post.PostsSection
import com.example.fluffy_aos.ui.post.reusable.PostCard
import com.example.fluffy_aos.ui.post.view_model.PostViewModel

@Composable
fun PostCards(postsSections: List<PostsSection>) {
    postsSections.forEachIndexed() { index, it ->
        PostCardsRow(it, index)
    }
}

@Composable
internal fun PostCardsRow(
    postsSection: PostsSection,
    sectionIndex: Int
) {

    val navController = LocalNavController.current

    Column {
        Row {
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            Text(
                postsSection.title,
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
            postsSection.posts.forEachIndexed { index, it ->
                Column(
                    modifier = Modifier.clickable {
                        navController.navigate("post_detail/${sectionIndex}/${index}")
                    }
                ) {
                    PostCard(it)
                }
            }
        }
    }
}