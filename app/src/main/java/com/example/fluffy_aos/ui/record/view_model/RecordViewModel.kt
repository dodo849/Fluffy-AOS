package com.example.fluffy_aos.ui.record.view_model

import com.example.fluffy_aos.data.db.PreferencesManager
import com.example.fluffy_aos.data.repository.BcsRepository
import com.example.fluffy_aos.data.repository.PetRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Date

class RecordViewModel(
    private val petRepository: PetRepository,
    private val bcsRepository: BcsRepository,
    private val preferenceManager: PreferencesManager = PreferencesManager,
) {

//    private val _bcs = MutableStateFlow<Map<Date, Map<String, String>>>(emptyMap())
//    val bcs: StateFlow<Map<Date, Map<String, String>>> = _bcs.asStateFlow()

    private val _weightList = MutableStateFlow<List<Double>>(emptyList())
    val weightList: StateFlow<List<Double>> = _weightList.asStateFlow()

    var bcsSurveyList: Map<Date, Map<String, String>> = emptyMap()

    init {
        getBcs()
        getWeight()
    }


    private fun getBcs() {
        val petId = preferenceManager.getValue("petId", "0L").toLong()
        bcsSurveyList = bcsRepository.readBcsByPet(petId = petId)
    }

    private fun getWeight() {
        val newWeightList = bcsSurveyList.map() { (date, bcsSurvey) ->
            bcsSurvey["weight"]?.toDouble() ?: 0.0
        }

        _weightList.update {
            newWeightList
        }
    }

}