package com.example.fluffy_aos.ui.common.survey.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.fluffy_aos.ui.common.survey.display_model.QuestionOrderType
import com.example.fluffy_aos.ui.common.survey.resuable.NumericField
import com.example.fluffy_aos.ui.common.survey.resuable.QuestionCard
import com.example.fluffy_aos.ui.common.survey.resuable.StringField

@Composable
fun StringQuestionCard(
    question: String,
    suffix: String = "",
    order: QuestionOrderType = QuestionOrderType.NOTHING,
    initialText: String,
    onClickPreviousButton: (Any) -> Unit,
    onClickNextButton: (Any) -> Unit,
) {
    var text by remember(question) { mutableStateOf(initialText) }

    QuestionCard(
        question = question,
        order = order,
        onClickPreviousButton = {
            onClickPreviousButton(text)
        },
        onClickNextButton = {
            onClickNextButton(text)
        },
    ) {
        StringField(text = text, onValueChange = { text = it })
    }
}
