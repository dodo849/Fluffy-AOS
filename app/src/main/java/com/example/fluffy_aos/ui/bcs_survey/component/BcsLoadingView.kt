package com.example.fluffy_aos.ui.bcs_survey.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.common.reusable.Card
import com.example.fluffy_aos.ui.theme.main_orange
import kotlinx.coroutines.delay

@Composable
fun BcsDiagnosisLoadingView(goNextPage: () -> Unit = {}) {
    var progressVisible by remember { mutableStateOf(true) }

    Card {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("AI 진단 중입니다", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator(
                Modifier.size(48.dp), main_orange, 3.dp
            )
        }
    }


    LaunchedEffect(Unit) {
        delay(4000L) // 3초 대기
        progressVisible = false
        goNextPage()
        // 이후에 다음 화면으로 이동하는 로직 추가
    }
}