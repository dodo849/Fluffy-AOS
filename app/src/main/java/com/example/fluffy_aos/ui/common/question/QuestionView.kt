package com.example.fluffy_aos.ui.common.question

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.fluffy_aos.model.question.BcsQuestion
import com.example.fluffy_aos.ui.common.funnel.Funnel
import com.example.fluffy_aos.ui.common.funnel.Step
import com.example.fluffy_aos.ui.common.question.component.NumericQuestionCard
import com.example.fluffy_aos.ui.common.question.component.SelectionQuestionCard

// TODO: BCSQuestionView 추상화하기
enum class QuestionOrder {
    FIRST, LAST, NOTHING
}

@Composable
fun QuestionView(
    questions: List<BcsQuestion>,
    onSubmit: (Map<String, Any>) -> Unit
) {
    var text by remember { mutableStateOf("") } // FIXME: temp

    var surveyResult by remember {
        mutableStateOf(mutableMapOf<String, Any>().apply {
            questions.forEach { question ->
                this[question.fieldName] = ""
            }
        })
    }

    Column {
        Funnel(
            result = surveyResult, // 퍼넬이 여기에 값 넣어줌
            steps = questions.mapIndexed { index, question ->
                Step(
                    name = question.fieldName
                ) {
                    getStepContent(
                        question = question,
                        value = surveyResult[question.fieldName] ?: "",
                        onClickPreviousButton = { input ->
                            it(questions.getOrNull(index - 1)?.fieldName, input)
                        },
                        onClickNextButton = { input ->
                            surveyResult[question.fieldName] = input
                            it(questions.getOrNull(index + 1)?.fieldName, input)
                        },
                        onSubmit = {
                            onSubmit(surveyResult)
                        }
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
    question: BcsQuestion,
    value: Any, // 기본 값. 이전값이 있다면 그 값
    onClickPreviousButton: (Any) -> Unit,
    onClickNextButton: (Any) -> Unit,
    onSubmit: () -> Unit
) {
    val QUESTION_DESCRIPTION = "Q${question.order}. ${question.description}"

    when (question.responseType) {
        "Real", "Integer" ->
            NumericQuestionCard(
                question = QUESTION_DESCRIPTION,
                initialText = value.toString(),
                onClickPreviousButton = onClickPreviousButton,
                onClickNextButton = onClickNextButton,
            )

        "Selection" -> {
            SelectionQuestionCard(
                question = QUESTION_DESCRIPTION,
                options = question.selections.map { it.description },
                initialSelected = value as Int,
                onClickPreviousButton = onClickPreviousButton,
                onClickNextButton = onClickNextButton,
            )
        }
    }
}