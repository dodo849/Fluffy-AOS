package com.example.fluffy_aos.ui.post.sub_page.post_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import coil.compose.rememberAsyncImagePainter
import com.example.fluffy_aos.model.post.Post
import com.example.fluffy_aos.model.post.PostContent
import com.example.fluffy_aos.model.post.postDummy
import com.example.fluffy_aos.ui.common.reusable.BackButton
import com.example.fluffy_aos.ui.theme.main_orange
import com.example.fluffy_aos.ui.theme.page_padding

@Composable
fun PostDetailView(navBackStackEntry: NavBackStackEntry) {

    val sectionId = navBackStackEntry.arguments?.getString("sectionId") ?: ""
    val postId = navBackStackEntry.arguments?.getString("postId") ?: ""

    var sectionTitle = ""
    var currentPost: Post? = null
    var imageUrl = ""
    postDummy.forEach {
        if (it.id == sectionId.toLong()) {
            sectionTitle = it.title
            it.posts.forEach { post ->
                if (post.id == postId.toLong()) {
                    currentPost = post
                    imageUrl = post.imageUrl
                }
            }
        }
    }
    val painter = rememberAsyncImagePainter(imageUrl)


    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(3.dp),
            modifier = Modifier
                .padding(page_padding)
        ) {
            BackButton()
            Spacer(modifier = Modifier.size(15.dp))
            Text(
                sectionTitle,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = main_orange
            )
            Text(
                currentPost?.title ?: "",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                currentPost?.subTitle ?: "",
                fontSize = 15.sp,
            )
        }
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
                .background(Color.LightGray)
        )

        currentPost?.content?.forEach {
            PostContent(it)
        }

        Spacer(modifier = Modifier.size(90.dp))

    }

}

@Composable
fun PostContent(content: PostContent) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = page_padding)
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        if (content.title != "")  {
            Text(
                content.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.size(10.dp))
        }

        Text(
            content.body,
            fontSize = 16.sp,
        )
    }

}