package com.example.fluffy_aos.ui.common.survey.resuable

import androidx.compose.runtime.Composable
import com.example.fluffy_aos.ui.common.survey.display_model.QuestionOrderType
import com.example.fluffy_aos.ui.common.reusable.RoundedButton
import com.example.fluffy_aos.ui.common.reusable.RoundedButtonState


@Composable
fun QuestionButtonGroup(
    order: QuestionOrderType,
    onClickPreviousButton: () -> Unit,
    onClickNextButton: () -> Unit,
) {

    val nextButtonText = if (order == QuestionOrderType.LAST) "완료하기" else "다음으로"

    if (order != QuestionOrderType.FIRST) {
        RoundedButton(
            onClick = onClickPreviousButton, state = RoundedButtonState.SECONDARY,
            text = "이전으로"
        )
    }

    RoundedButton(onClick = onClickNextButton, text = nextButtonText)

}