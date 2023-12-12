package com.example.fluffy_aos.ui.home.sub_page.bcs_survey.view_model

import androidx.lifecycle.ViewModel
import com.example.fluffy_aos.data.db.PreferencesManager
import com.example.fluffy_aos.data.repository.BcsRepository
import com.example.fluffy_aos.data.repository.PetRepository
import com.example.fluffy_aos.data.repository.PredictRepository
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

        val predictDto = pridectRequestPreprocess(surveyResult, petId)
        CoroutineScope(Dispatchers.IO).async {
            val result = PredictRepository().sendHttpPostRequest(predictDto)
            println("result = $result")
        }
    }

    private fun pridectRequestPreprocess(survey: Map<String, Any>, petId: Long): PredictRequestDto {

        val mutableSurvey = survey.toMutableMap()

        val pet = PetRepository().readPetById(petId)

//        val name: String,
//        val species: String,
//        val breed: String,
//        val furType: String,
//        val age: Int,
//        val sex: String

        val petConverter = PetConverter()

        mutableSurvey["species"] =  petConverter.descriptionToOrder("species", pet?.species ?: "")
        mutableSurvey["breed"] = petConverter.descriptionToOrder("breed", pet?.breed ?: "")
        mutableSurvey["class"] = petConverter.descriptionToOrder("furType", pet?.furType ?: "")
        mutableSurvey["age"] = pet?.age ?: ""
        mutableSurvey["sex"] = petConverter.descriptionToOrder("sex", pet?.sex ?: "")

        val predictItem = mutableSurvey.map {
            PredictItem(
                fieldName = it.key,
                value = it.value.toString().toInt()
            )
        }
        return PredictRequestDto(predictItem)
    }

}