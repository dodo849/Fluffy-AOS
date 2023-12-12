package com.example.fluffy_aos.ui.home.sub_page.bcs_survey

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
import com.example.fluffy_aos.model.bcs.BcsLevel
import com.example.fluffy_aos.ui.home.sub_page.bcs_survey.view_model.BcsSurveyViewModel
import com.example.fluffy_aos.ui.common.funnel.Funnel
import com.example.fluffy_aos.ui.common.funnel.Step
import com.example.fluffy_aos.ui.common.survey.SurveyView
import com.example.fluffy_aos.ui.common.reusable.BackButton
import com.example.fluffy_aos.ui.home.sub_page.bcs_survey.component.BcsLoadingPage
import com.example.fluffy_aos.ui.home.sub_page.bcs_survey.component.BcsResultPage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

@Composable
fun BcsSurveyView(
    viewModel: BcsSurveyViewModel
) {
    val navController = LocalNavController.current

    val questions by viewModel.questions.collectAsState()

    var text by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(25.dp, 25.dp, 25.dp, 25.dp)
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
                            viewModel.saveBcs(it)
                            onChangeStep("loading")
                        }
                    )
                },
                Step(
                    name = "loading",
                ) {onChangeStep ->
                    BcsLoadingPage {
                        onChangeStep("result")
                    }
                },
                Step(
                    name = "result"
                ) { onChangeStep ->
                    BcsResultPage(bcsLevel = BcsLevel.LEVEL_3)
                }
            )
        )
    }
}
