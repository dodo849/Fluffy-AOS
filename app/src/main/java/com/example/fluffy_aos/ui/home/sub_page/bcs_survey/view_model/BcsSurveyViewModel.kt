package com.example.fluffy_aos.ui.home.sub_page.bcs_survey.view_model

import androidx.lifecycle.ViewModel
import com.example.fluffy_aos.data.db.PreferencesManager
import com.example.fluffy_aos.data.repository.BcsRepository
import com.example.fluffy_aos.model.question.QuestionModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BcsSurveyViewModel(
    private val bcsRepository: BcsRepository,
    private val preferencesManager: PreferencesManager = PreferencesManager,
): ViewModel() {

    private val _questions = MutableStateFlow<List<QuestionModel>>(emptyList())
    val questions: StateFlow<List<QuestionModel>> = _questions.asStateFlow()

    val surveyResult = mutableMapOf<String, Any>()

    init {
        getBcsQuestion()

//        val temp = bcsRepository.readAllBcs()
//        println("_questions = ${temp}")
    }

    private fun getBcsQuestion() {

        val bcsSurvey = bcsRepository.getBcsSurvey()

        _questions.update { currentState ->
            bcsSurvey?.questions ?: emptyList()
        }
    }

    fun saveBcs(surveyResult: Map<String, Any>) {
        val petId = preferencesManager.getValue("petId", "0L").toLong()
        bcsRepository.saveBcs(petId, surveyResult)
    }
}