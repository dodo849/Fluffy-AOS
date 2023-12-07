package com.example.fluffy_aos.ui.common.question.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.fluffy_aos.ui.common.question.resuable.NumericField
import com.example.fluffy_aos.ui.common.question.resuable.QuestionCard

@Composable
fun NumericQuestionCard(
    question: String,
    suffix: String = "",
    initialText: String,
    onClickPreviousButton: (Any) -> Unit,
    onClickNextButton: (Any) -> Unit
) {
    var text by remember { mutableStateOf(initialText) }

    QuestionCard(
        question = question,
        onClickPreviousButton = {
            onClickPreviousButton(text)
//            text = initialText
        },
        onClickNextButton = {
            onClickNextButton(text)
//            text = initialText
        },
    ) {
        NumericField(suffix = suffix, text = text, onValueChange = { text = it })
    }
}
