package com.example.fluffy_aos.ui.setting.sub_page.onboarding_survey.view_model

import androidx.lifecycle.ViewModel
import com.example.fluffy_aos.data.db.PreferencesManager
import com.example.fluffy_aos.data.repository.OnboardingRepository
import com.example.fluffy_aos.data.repository.PetRepository
import com.example.fluffy_aos.model.pet.Pet
import com.example.fluffy_aos.model.pet.PetConverter
import com.example.fluffy_aos.model.question.QuestionModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OnboardingSurveyViewModel(
    private val onboardingRepository: OnboardingRepository,
    private val petRepository: PetRepository,
    private val petConverter: PetConverter = PetConverter(),
    private val preferencesManager: PreferencesManager = PreferencesManager,
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
        val speciesCode = petConverter.orderToCodeByField(
            "species",
            surveyResult["species"].toString().toInt()
        )
        val breedCode = petConverter.orderToCodeByField(
            "breed",
            surveyResult["breed"].toString().toInt()
        )
        val furTypeCode = petConverter.orderToCodeByField(
            "furType",
            surveyResult["furType"].toString().toInt()
        )
        val sexCode = petConverter.orderToCodeByField(
            "sex",
            surveyResult["sex"].toString().toInt()
        )

        petRepository.insertPet(
            Pet(
                name = surveyResult["name"].toString(),
                species = speciesCode ?: "",
                breed = breedCode ?: "",
                furType = furTypeCode ?: "",
                age = surveyResult["age"].toString().toInt(),
                sex = sexCode ?: ""
            )
        )

        // 선택된 반려동물이 없으면 현재 등록한 펫을 선택
        val petId = preferencesManager.getValue("petId", "0L").toLong()
        if (petId == 0L) {
            val pet = petRepository.readAllPets().last()
            preferencesManager.saveValue("petId", pet.id.toString())
        }
    }
}