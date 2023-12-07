package com.example.fluffy_aos.ui.bcs_diagnosis

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
import com.example.fluffy_aos.ui.bcs_diagnosis.view_model.BcsDiagnosisViewModel
import com.example.fluffy_aos.ui.common.survey.SurveyView
import com.example.fluffy_aos.ui.common.reusable.BackButton

@Composable
fun BcsDiagnosisView(
    viewModel: BcsDiagnosisViewModel
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

        SurveyView(
            questions = questions.map { it.mapToDisplayModel() },
            onSubmit = { viewModel.saveBcs() })
    }
}
