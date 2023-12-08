package com.example.fluffy_aos.ui.onboarding_survey.view_model

import androidx.lifecycle.ViewModel
import com.example.fluffy_aos.db.BcsRepository
import com.example.fluffy_aos.db.OnboardingRepository
import com.example.fluffy_aos.db.PetRepository
import com.example.fluffy_aos.model.pet.Pet
import com.example.fluffy_aos.model.question.QuestionModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OnboardingSurveyViewModel(
    private val onboardingRepository: OnboardingRepository,
    private val petRepository: PetRepository
) : ViewModel() {

    private val _questions = MutableStateFlow<List<QuestionModel>>(emptyList())
    val questions: StateFlow<List<QuestionModel>> = _questions.asStateFlow()

    init {
        getOnboardingSurvey()
    }

    private fun getOnboardingSurvey() {

        val survey = onboardingRepository.getOnboardingSurvey()

        _questions.update { currentState ->
            survey?.questions ?: emptyList()
        }
    }

    fun savePet(surveyResult: Map<String, Any>) {
        petRepository.insertPet(
            Pet(
                name = surveyResult["name"].toString(),
                species = surveyResult["species"].toString(),
                breed = surveyResult["breed"].toString(),
                furType = surveyResult["furType"].toString(),
                age = surveyResult["age"].toString().toInt(),
                sex = surveyResult["sex"].toString()
            )
        )
    }
}