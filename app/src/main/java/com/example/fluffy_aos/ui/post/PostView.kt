package com.example.fluffy_aos.ui.post

import PostCategories
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.global.LocalNavControllerProvider
import com.example.fluffy_aos.ui.post.component.PostCards
import com.example.fluffy_aos.ui.post.view_model.PostViewModel
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme

@Composable
fun PostView(viewModel: PostViewModel) {
//    val navController = LocalNavController.current
    val state by viewModel.post.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                "포스팅",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            PostCategories(
                state.selectedCategory
            ) {
                viewModel.selectCategory(it)
            }
        }

        PostCards(state.posts)

        Spacer(modifier = Modifier.height(50.dp))

    }
}


@Preview(showBackground = true)
@Composable
fun PostViewPreview() {
    LocalNavControllerProvider {
        FluffyAOSTheme {
            PostView(PostViewModel())
        }
    }
}