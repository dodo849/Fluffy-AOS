package com.example.fluffy_aos.ui.post.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.post.reusable.PostCard

@Composable
fun PostCards() {
    PostCardsRow("다이어트 정보")
    PostCardsRow("운동 정보")
    PostCardsRow("영양 정보")
}

@Composable 
internal fun PostCardsRow(title: String) {
    Column {
        Row {
            Spacer(modifier = Modifier.padding(horizontal = 20.dp))
            Text(
                "다이어트 정보",
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
            PostCard("강아지 다이어트 어떻게 해야할까요?", "건강하게 오래오래 함께하는 법")
            PostCard("강아지 다이어트 어떻게 해야할까요?", "건강하게 오래오래 함께하는 법")
            PostCard("강아지 다이어트 어떻게 해야할까요?", "건강하게 오래오래 함께하는 법")
        }
    }
}