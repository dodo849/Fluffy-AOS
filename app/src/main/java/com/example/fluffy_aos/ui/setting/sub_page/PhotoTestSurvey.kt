package com.example.fluffy_aos.ui.setting.sub_page

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.fluffy_aos.data.repository.BcsRepository
import com.example.fluffy_aos.model.question.QuestionModel
import com.example.fluffy_aos.ui.common.reusable.BackButton
import com.example.fluffy_aos.ui.common.survey.SurveyView


@Composable
fun PhotoTestSurvey() {

    val questions = BcsRepository().getBcsPhotoSurvey()?.questions.orEmpty()

    BackButton()
    SurveyView(questions = questions.map { it.mapToDisplayModel() }, onSubmit = { println(it) })

}