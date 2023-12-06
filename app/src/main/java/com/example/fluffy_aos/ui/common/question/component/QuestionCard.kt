package com.example.fluffy_aos.ui.common.question.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.common.question.resuable.NumericField
import com.example.fluffy_aos.ui.common.question.resuable.SelectionField
import com.example.fluffy_aos.ui.common.reusable.Card
import com.example.fluffy_aos.ui.common.reusable.RoundedButton
import com.example.fluffy_aos.ui.common.reusable.RoundedButtonState

enum class QuestionType {
    NUMERIC,
    SELECTION,
}

@Composable
fun QuestionCard(
    questionType: QuestionType,
    question: String,
    suffix: String = "",
    options: List<String> = listOf(),
    onClickPreviousButton: () -> Any,
    onClickNextButton: (String) -> Any?,
) {
    var text by remember { mutableStateOf("") }
    var selectedOption by remember { mutableStateOf(0) }

    Card {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp), modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                question,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )

            when (questionType) {
                QuestionType.NUMERIC ->
                    NumericField(suffix = suffix, text = text, onValueChange = { text = it })

                QuestionType.SELECTION ->
                    SelectionField(options = options, onValueChange = { selectedOption = it })
            }


            RoundedButton(
                onClick = {
                    text = onClickPreviousButton().toString()
                }, state = RoundedButtonState.SECONDARY,
                text = "이전으로"
            )

            RoundedButton(onClick = {
                val nextValue = onClickNextButton(text)
                text = nextValue?.toString() ?: ""
            }, text = "다음으로")
        }
    }
}