package com.example.fluffy_aos.ui.home.component

import androidx.compose.runtime.Composable
import com.example.fluffy_aos.R
import com.example.fluffy_aos.ui.home.reusable.DiagnosisCardView


@Composable
fun EyeDiagnosisCard() {
    DiagnosisCardView(
        title = "AI 안구 진단",
        detail = "이미지를 이용해 안구 질환을 진단해드려요. 병원 가기 전 간단하게 미리 검사해보세요.",
        imageRes = R.drawable.dog_and_cat,
        onClick = { /*TODO*/ }
    )
}