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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fluffy_aos.funnel.Funnel
import com.example.fluffy_aos.funnel.Step
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.model.question.BcsQuestion
import com.example.fluffy_aos.ui.bcs_diagnosis.component.BcsDiagnosisTitle
import com.example.fluffy_aos.ui.bcs_diagnosis.component.BcsNumericQuestion
import com.example.fluffy_aos.ui.bcs_diagnosis.component.BcsSelectQuestion
import com.example.fluffy_aos.ui.bcs_diagnosis.view_model.BcsDiagnosisViewModel
import com.example.fluffy_aos.ui.common.BackButton

@Composable
fun BcsDiagnosisView(
    viewModel: BcsDiagnosisViewModel
) {
    val navController = LocalNavController.current

    val questions by viewModel.questions.collectAsState()

    var currentInput by remember { mutableStateOf("") }

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

            BcsDiagnosisTitle()

            Funnel(
                result = viewModel.surveyResult,
                steps = questions.mapIndexed { index, question ->
                    var QUESTION_DESCRIPTION = "Q${question.order}. ${question.description}"
                    Step(
                        name = question.fieldName,
                        content = {
                            getStepContent(
                                question = question,
                                callback = { input ->
                                    it(
                                        questions.getOrNull(index + 1)?.fieldName,
                                        input
                                    )
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
    callback: (Any?) -> Unit
) {
    val QUESTION_DESCRIPTION = "Q${question.order}. ${question.description}"
    when (question.responseType) {
        "Real", "Integer" -> {
            BcsNumericQuestion(
                question = QUESTION_DESCRIPTION,
                suffix = question.responseSuffix,
                onClickNextButton = callback
            )
        }
        "Selection" -> {
            BcsSelectQuestion(
                question = QUESTION_DESCRIPTION,
                options = question.selections.map { it.description },
                onClickNextButton = callback
            )
        }
    }
}