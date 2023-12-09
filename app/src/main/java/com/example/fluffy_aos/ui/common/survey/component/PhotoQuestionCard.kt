package com.example.fluffy_aos.ui.common.survey.component

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.fluffy_aos.ui.common.survey.display_model.QuestionOrderType
import com.example.fluffy_aos.ui.common.survey.resuable.PhotoField
import com.example.fluffy_aos.ui.common.survey.resuable.QuestionCard
import com.example.fluffy_aos.ui.common.survey.resuable.SelectionField

@Composable
fun PhotoQuestionCard(
    question: String,
    order: QuestionOrderType = QuestionOrderType.NOTHING,
    initialUri: Uri = Uri.EMPTY,
    onClickPreviousButton: (Any) -> Unit,
    onClickNextButton: (Any) -> Unit
) {

    var photoUri by remember(question) { mutableStateOf(initialUri)  }

    QuestionCard(
        question = question,
        order = order,
        onClickPreviousButton = { onClickPreviousButton(photoUri) },
        onClickNextButton = { onClickNextButton(photoUri) },
    ) {
        PhotoField(photoUri, onChangeValue = { photoUri = it })
    }
}