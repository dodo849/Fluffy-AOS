package com.example.fluffy_aos.ui.post

import PostCategories
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.global.LocalNavControllerProvider
import com.example.fluffy_aos.model.dogPostDummy
import com.example.fluffy_aos.ui.post.component.PostCards
import com.example.fluffy_aos.ui.record.RecordView
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme
import com.example.fluffy_aos.ui.theme.gray_background
import com.example.fluffy_aos.ui.theme.gray_outline
import com.example.fluffy_aos.ui.theme.gray_text_light
import com.example.fluffy_aos.ui.theme.main_orange
import com.example.fluffy_aos.ui.theme.main_orange_light

@Composable
fun PostView() {
    val navController = LocalNavController.current
    var selectedCategory by remember { mutableStateOf("전체") }


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
                "포스팅", fontWeight = FontWeight.Bold, fontSize = 24.sp
            )
            PostCategories()
        }

        PostCards(dogPostDummy)

        Spacer(modifier = Modifier.height(50.dp))

    }
}


@Preview(showBackground = true)
@Composable
fun PostViewPreview() {
    LocalNavControllerProvider {
        FluffyAOSTheme {
            PostView()
        }
    }
}