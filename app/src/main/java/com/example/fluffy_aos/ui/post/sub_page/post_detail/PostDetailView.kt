package com.example.fluffy_aos.ui.post.sub_page.post_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavBackStackEntry
import com.example.fluffy_aos.model.post.Post
import com.example.fluffy_aos.model.post.postDummy
import com.example.fluffy_aos.ui.common.reusable.BackButton
import com.example.fluffy_aos.ui.post.view_model.PostViewModel

@Composable
fun PostDetailView(viewModel: PostViewModel) {

    val post by viewModel.selectedPost.collectAsState()


    Column {
        BackButton()
        Text(post.title)
    }

}