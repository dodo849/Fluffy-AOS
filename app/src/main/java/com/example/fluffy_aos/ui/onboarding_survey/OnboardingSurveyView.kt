package com.example.fluffy_aos.ui.onboarding_survey

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.home.sub_page.bcs_survey.component.BcsResultPage
import com.example.fluffy_aos.ui.home.sub_page.bcs_survey.view_model.BcsSurveyViewModel
import com.example.fluffy_aos.ui.common.funnel.Funnel
import com.example.fluffy_aos.ui.common.funnel.Step
import com.example.fluffy_aos.ui.common.reusable.BackButton
import com.example.fluffy_aos.ui.common.survey.SurveyView
import com.example.fluffy_aos.ui.onboarding_survey.view_model.OnboardingSurveyViewModel
import com.example.fluffy_aos.ui.theme.page_padding

@Composable
fun OnboardingSurveyView(
    viewModel: OnboardingSurveyViewModel
) {
    val navController = LocalNavController.current

    val questions by viewModel.questions.collectAsState()

    var text by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(page_padding)
    ) {
        BackButton()

        Funnel(
            steps = listOf(
                Step(
                    name = "bcs-survey"
                ) { onChangeStep ->
                    SurveyView(
                        questions = questions.map { it.mapToDisplayModel() },
                        onSubmit = {
                            onChangeStep("result")
                        }
                    )
                },
                Step(
                    name = "result"
                ) { onChangeStep ->
                    BcsResultPage()
                }
            )
        )
    }
}
