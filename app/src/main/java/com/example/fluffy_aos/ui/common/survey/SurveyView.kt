package com.example.fluffy_aos.ui.common.survey

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.fluffy_aos.ui.common.funnel.Funnel
import com.example.fluffy_aos.ui.common.funnel.Step
import com.example.fluffy_aos.ui.common.survey.component.DropdownQuestionCard
import com.example.fluffy_aos.ui.common.survey.component.NumericQuestionCard
import com.example.fluffy_aos.ui.common.survey.component.PhotoQuestionCard
import com.example.fluffy_aos.ui.common.survey.component.SelectionQuestionCard
import com.example.fluffy_aos.ui.common.survey.component.StringQuestionCard
import com.example.fluffy_aos.ui.common.survey.display_model.QuestionDisplayModel
import com.example.fluffy_aos.ui.common.survey.display_model.QuestionOrderType


@Composable
fun SurveyView(
    questions: List<QuestionDisplayModel>,
    onSubmit: (Map<String, Any>) -> Unit
) {
    var text by remember { mutableStateOf("") } // FIXME: temp

    // NOTE: Selection의 경우 order로 저장 나중에 데이터 처리할때 code로 바꿔야함
    var surveyResult by rememberSaveable {
        mutableStateOf(mutableMapOf<String, Any>().apply {
            questions.forEach { question ->
                this[question.fieldName] = ""
            }
        })
    }

    Column {
        Funnel(
            steps = questions.mapIndexed { index, question ->
                val questionOrderType = QuestionOrderType.from(index + 1, questions.size)
                Step(
                    name = question.fieldName
                ) { onChangeStep ->
                    getStepContent(
                        question = question,
                        suffix = question.responseSuffix,
                        orderType = questionOrderType,
                        value = surveyResult[question.fieldName] ?: "",
                        onClickPreviousButton = { input ->
                            onChangeStep(questions.getOrNull(index - 1)?.fieldName)
                            surveyResult[question.fieldName] = input
                        },
                        onClickNextButton = { input ->
                            surveyResult[question.fieldName] = input
                            if (questionOrderType == QuestionOrderType.LAST) {
                                onSubmit(surveyResult)
                            } else {
                                onChangeStep(questions.getOrNull(index + 1)?.fieldName)
                            }
                        },
                    )
                }
            }
        )
        Button(onClick = { text = surveyResult.toString() }) {
            Text("show result")
        }
        Text("${text}")
    }
}


@Composable
private fun getStepContent(
    question: QuestionDisplayModel,
    orderType: QuestionOrderType,
    suffix: String = "",
    value: Any, // 기본 값. 이전값이 있다면 그 값
    onClickPreviousButton: (Any) -> Unit,
    onClickNextButton: (Any) -> Unit,
) {
    val QUESTION_DESCRIPTION = "Q${question.order}. ${question.description}"

    when (question.responseType) {
        "Real", "Integer" ->
            NumericQuestionCard(
                question = QUESTION_DESCRIPTION,
                initialText = value.toString(),
                suffix = suffix,
                order = orderType,
                onClickPreviousButton = onClickPreviousButton,
                onClickNextButton = onClickNextButton,
            )

        "Selection" -> {
            SelectionQuestionCard(
                question = QUESTION_DESCRIPTION,
                options = question.selections.map { it.description },
                order = orderType,
                initialSelected = (value.toString().toIntOrNull() ?: 0),
                onClickPreviousButton = onClickPreviousButton,
                onClickNextButton = onClickNextButton,
            )
        }

        "String" -> {
            StringQuestionCard(
                question = QUESTION_DESCRIPTION,
                initialText = value.toString(),
                order = orderType,
                onClickPreviousButton = onClickPreviousButton,
                onClickNextButton = onClickNextButton,
            )
        }

        "Dropdown" -> {
            DropdownQuestionCard(
                question = QUESTION_DESCRIPTION,
                options = question.selections.map { it.description },
                order = orderType,
                initialSelected = (value.toString().toIntOrNull() ?: 0),
                onClickPreviousButton = onClickPreviousButton,
                onClickNextButton = onClickNextButton,
            )
        }

        "Photo" -> {
            PhotoQuestionCard(
                question = QUESTION_DESCRIPTION,
                order = orderType,
                initialUri = Uri.parse(value.toString()),
                onClickPreviousButton = onClickPreviousButton,
                onClickNextButton = onClickNextButton,
            )
        }
    }
}