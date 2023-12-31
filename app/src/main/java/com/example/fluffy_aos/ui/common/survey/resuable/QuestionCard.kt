package com.example.fluffy_aos.ui.common.survey.resuable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fluffy_aos.ui.common.survey.display_model.QuestionOrderType
import com.example.fluffy_aos.ui.common.reusable.Card


// TODO: 알았다 이거 Selection, Numeric 구분해야함 -> 다시다시
@Composable
fun QuestionCard(
    question: String,
    order: QuestionOrderType,
    onClickPreviousButton: () -> Unit,
    onClickNextButton: () -> Unit,
    field : @Composable () -> Unit
) {


    Card {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp), modifier = Modifier.fillMaxWidth()
        ) {
            QuestionCardTitle(question)

            field()

            QuestionButtonGroup(
                order = order,
                onClickPreviousButton = onClickPreviousButton,
                onClickNextButton = onClickNextButton)
        }
    }
}