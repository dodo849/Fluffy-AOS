package com.example.fluffy_aos.ui.bcs_diagnosis.view_model

import androidx.lifecycle.ViewModel
import com.example.fluffy_aos.db.BcsRepository
import com.example.fluffy_aos.model.question.BcsQuestionModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BcsDiagnosisViewModel(
    private val bcsRepository: BcsRepository
): ViewModel() {

    private val _questions = MutableStateFlow<List<BcsQuestionModel>>(emptyList())
    val questions: StateFlow<List<BcsQuestionModel>> = _questions.asStateFlow()

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

    fun saveBcs() {
//        bcsRepository.insertBcs(surveyResult)
    }
}