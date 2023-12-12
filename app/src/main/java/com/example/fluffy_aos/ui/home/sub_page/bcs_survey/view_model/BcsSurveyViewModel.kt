package com.example.fluffy_aos.ui.home.sub_page.bcs_survey.view_model

import androidx.lifecycle.ViewModel
import com.example.fluffy_aos.data.db.PreferencesManager
import com.example.fluffy_aos.data.repository.BcsRepository
import com.example.fluffy_aos.data.repository.PetRepository
import com.example.fluffy_aos.data.repository.PredictRepository
import com.example.fluffy_aos.model.bcs.BcsLevel
import com.example.fluffy_aos.model.pet.PetConverter
import com.example.fluffy_aos.model.predict.PredictItem
import com.example.fluffy_aos.model.predict.PredictRequestDto
import com.example.fluffy_aos.model.question.QuestionModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BcsSurveyViewModel(
    private val bcsRepository: BcsRepository,
    private val preferencesManager: PreferencesManager = PreferencesManager,
) : ViewModel() {

    private val _questions = MutableStateFlow<List<QuestionModel>>(emptyList())
    val questions: StateFlow<List<QuestionModel>> = _questions.asStateFlow()

    private val _bcsLevel = MutableStateFlow<BcsLevel>(BcsLevel.LEVEL_1)
    val bcsLevel: StateFlow<BcsLevel> = _bcsLevel.asStateFlow()

    val surveyResult = mutableMapOf<String, Any>()

    init {
        getBcsQuestion()
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

        val predictDto = pridectRequestPreprocess(surveyResult, petId)
        CoroutineScope(Dispatchers.IO).async {
            val result = PredictRepository().sendHttpPostRequest(predictDto)
            _bcsLevel.update {
                BcsLevel.numToBcsLevel(result?.bcs ?: 0)
            }
            preferencesManager.saveValue("bcs_level", result?.bcs.toString())
            println("bcs result = $result")
        }
    }

    private fun pridectRequestPreprocess(survey: Map<String, Any>, petId: Long): PredictRequestDto {

        val mutableSurvey = survey.toMutableMap()

        val pet = PetRepository().readPetById(petId)

        val petConverter = PetConverter()

//        mutableSurvey["species"] =  petConverter.descriptionToOrder("species", pet?.species ?: "") // 현재 반려견만 지원
        mutableSurvey["breed"] = petConverter.descriptionToOrder("breed", pet?.breed ?: "")
        mutableSurvey["class"] = petConverter.descriptionToOrder("furType", pet?.furType ?: "")
        mutableSurvey["age"] = pet?.age ?: ""
        mutableSurvey["sex"] = petConverter.descriptionToOrder("sex", pet?.sex ?: "")
        mutableSurvey["group"] = 1

        mutableSurvey.remove("photo-1")
        mutableSurvey.remove("photo-2")
        mutableSurvey.remove("photo-3")

        val predictItem = mutableSurvey.map {
            PredictItem(
                fieldName = it.key,
                value = it.value.toString().toInt()
            )
        }

        return PredictRequestDto(predictItem)
    }

}