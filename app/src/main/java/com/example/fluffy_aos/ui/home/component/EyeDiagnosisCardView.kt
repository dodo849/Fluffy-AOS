package com.example.fluffy_aos.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.R
import com.example.fluffy_aos.ui.common.RoundedButton
import com.example.fluffy_aos.ui.home.reusable.DiagnosisCardView


@Composable
fun EyeDiagnosisCardView() {
    DiagnosisCardView(
        title = "AI 안구 진단",
        detail = "이미지를 이용해 안구 질환을 진단해드려요. 병원 가기 전 간단하게 미리 검사해보세요.",
        imageRes = R.drawable.dog_and_cat,
        onClick = { /*TODO*/ }
    )
}