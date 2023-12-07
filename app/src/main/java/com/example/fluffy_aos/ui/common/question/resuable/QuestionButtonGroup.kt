package com.example.fluffy_aos.ui.common.question.resuable

import androidx.compose.runtime.Composable
import com.example.fluffy_aos.ui.common.question.display_model.QuestionOrder
import com.example.fluffy_aos.ui.common.reusable.RoundedButton
import com.example.fluffy_aos.ui.common.reusable.RoundedButtonState


@Composable
fun QuestionButtonGroup(
    order: QuestionOrder,
    onClickPreviousButton: () -> Unit,
    onClickNextButton: () -> Unit,
    onSubmit: () -> Unit = {},
) {

    if (order != QuestionOrder.FIRST) {
        RoundedButton(
            onClick = onClickPreviousButton, state = RoundedButtonState.SECONDARY,
            text = "이전으로"
        )
    }

    if (order == QuestionOrder.LAST) {
        RoundedButton(onClick = {
            onSubmit()
            onClickNextButton()
        }, text = "완료하기")

    } else {
        RoundedButton(onClick = onClickNextButton, text = "다음으로")

    }
}