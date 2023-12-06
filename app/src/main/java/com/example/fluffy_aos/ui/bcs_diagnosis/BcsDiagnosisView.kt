package com.example.fluffy_aos.ui.bcs_diagnosis

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fluffy_aos.ui.common.funnel.Funnel
import com.example.fluffy_aos.ui.common.funnel.Step
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.model.question.BcsQuestion
import com.example.fluffy_aos.ui.common.question.component.QuestionCard
import com.example.fluffy_aos.ui.common.question.component.QuestionType
import com.example.fluffy_aos.ui.bcs_diagnosis.view_model.BcsDiagnosisViewModel
import com.example.fluffy_aos.ui.common.reusable.BackButton

@Composable
fun BcsDiagnosisView(
    viewModel: BcsDiagnosisViewModel
) {
    val navController = LocalNavController.current

    val questions by viewModel.questions.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(25.dp, 25.dp, 25.dp, 25.dp)
    ) {
        BackButton()

        Column {

            Button(onClick = { println(viewModel.surveyResult) }) {

            }

//            BcsDiagnosisTitle()

            Funnel(
                result = viewModel.surveyResult,
                steps = questions.mapIndexed { index, question ->
                    Step(
                        name = question.fieldName,
                        content = {
                            getStepContent(
                                question = question,
                                onClickPreviousButton = {
                                    val previousFieldName =
                                        questions.getOrNull(index - 1)?.fieldName
                                    it(previousFieldName, null)
                                    viewModel.surveyResult[previousFieldName ?: ""] ?: ""
                                },
                                onClickNextButton = { input ->
                                    val nextFieldName =
                                        questions.getOrNull(index + 1)?.fieldName
                                    it(nextFieldName, input)
                                    viewModel.surveyResult[nextFieldName] ?: ""
                                })
                        }
                    )
                }
            )
        }

    }
}


@Composable
private fun getStepContent(
    question: BcsQuestion,
    onClickPreviousButton: () -> Any,
    onClickNextButton: (Any?) -> Any
) {
    val QUESTION_DESCRIPTION = "Q${question.order}. ${question.description}"
    when (question.responseType) {
        "Real", "Integer" -> {
            QuestionCard(
                questionType = QuestionType.NUMERIC,
                question = QUESTION_DESCRIPTION,
                suffix = question.responseSuffix,
                onClickPreviousButton = onClickPreviousButton,
                onClickNextButton = onClickNextButton
            )
        }

        "Selection" -> {
            QuestionCard(
                questionType = QuestionType.SELECTION,
                question = QUESTION_DESCRIPTION,
                options = question.selections.map { it.description },
                onClickPreviousButton = onClickPreviousButton,
                onClickNextButton = onClickNextButton
            )
        }
    }
}