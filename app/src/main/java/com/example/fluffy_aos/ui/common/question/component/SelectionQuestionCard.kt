package com.example.fluffy_aos.ui.common.question.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.fluffy_aos.ui.common.question.resuable.QuestionCard
import com.example.fluffy_aos.ui.common.question.resuable.SelectionField


@Composable
fun SelectionQuestionCard(
    question: String,
    options: List<String>,
    initialSelected: Int = 0,
    onClickPreviousButton: (Any) -> Unit,
    onClickNextButton: (Any) -> Unit
) {

    var selectedOption by remember(initialSelected) { mutableStateOf(initialSelected)  }

    QuestionCard(
        question = question,
        onClickPreviousButton = { onClickPreviousButton(selectedOption) },
        onClickNextButton = { onClickNextButton(selectedOption) },
    ) {
        SelectionField(
            options = options,
            selectedOption = selectedOption,
            onValueChange = {}
        )
    }
}