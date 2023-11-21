package com.example.fluffy_aos.ui.bcs_diagnosis.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.theme.gray_text_light

@Composable
fun BcsDiagnosisTitle() {
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        Text(
            "BCS 진단",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            "AI BCS(Body Condition Score) 진단을 위한 문답입니다.",
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = gray_text_light
        )
    }
}