package com.example.fluffy_aos.ui.home.component

import androidx.compose.runtime.Composable
import com.example.fluffy_aos.R
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.home.reusable.DiagnosisCardView


@Composable
fun BcsDiagnosisCard() {
    val navController = LocalNavController.current

    DiagnosisCardView(
        title = "AI BCS(비만도) 진단",
        detail = "가정에서 측정할 수 있는 수치로 BCS를 진단해드려요. 다양한 각도에서 찍은 사진을 첨부한다면 더욱 정확해진답니다!",
        imageRes = R.drawable.dog_and_cat,
        onClick = { navController.navigate("bcs_survey") }
    )
}