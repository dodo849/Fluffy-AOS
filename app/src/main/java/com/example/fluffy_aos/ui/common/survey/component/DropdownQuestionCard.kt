package com.example.fluffy_aos.ui.common.survey.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.fluffy_aos.ui.common.survey.display_model.QuestionOrderType
import com.example.fluffy_aos.ui.common.survey.resuable.DropdownField
import com.example.fluffy_aos.ui.common.survey.resuable.NumericField
import com.example.fluffy_aos.ui.common.survey.resuable.QuestionCard
import com.example.fluffy_aos.ui.common.survey.resuable.SelectionField
import com.example.fluffy_aos.ui.common.survey.resuable.StringField

@Composable
fun DropdownQuestionCard(
    question: String,
    options: List<String>,
    order: QuestionOrderType = QuestionOrderType.NOTHING,
    initialSelected: Int,
    onClickPreviousButton: (Any) -> Unit,
    onClickNextButton: (Any) -> Unit,
) {

    var selectedOption by remember(question) { mutableStateOf(initialSelected)  }

    QuestionCard(
        question = question,
        order = order,
        onClickPreviousButton = {
            onClickPreviousButton(selectedOption)
        },
        onClickNextButton = {
            onClickNextButton(selectedOption)
        },
    ) {
        DropdownField(
            options = options,
            initialSelected = selectedOption,
            onValueChange = {
                selectedOption = it
            }
        )
    }
}
