package com.example.fluffy_aos.ui.common.question.resuable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun QuestionCardTitle(question: String) {
    Text(
        question,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
    )
}