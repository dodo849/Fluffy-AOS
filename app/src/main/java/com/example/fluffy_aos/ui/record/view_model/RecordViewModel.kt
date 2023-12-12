package com.example.fluffy_aos.ui.record.view_model

import com.example.fluffy_aos.data.db.PreferencesManager
import com.example.fluffy_aos.data.repository.BcsRepository
import com.example.fluffy_aos.data.repository.PetRepository
import com.example.fluffy_aos.model.bcs.BcsLevel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.Date

class RecordViewModel(
    private val petRepository: PetRepository,
    private val bcsRepository: BcsRepository,
    private val preferenceManager: PreferencesManager = PreferencesManager,
) {

    /// Par<날짜, 체중> : 날짜-X축, 체중-Y축
    private val _weightList = MutableStateFlow<List<Pair<String, Double>>>(emptyList())
    val weightList: StateFlow<List<Pair<String, Double>>> = _weightList.asStateFlow()

    private val _bcsLevel = MutableStateFlow<BcsLevel>(BcsLevel.LEVEL_1)
    val bcsLevel: StateFlow<BcsLevel> = _bcsLevel.asStateFlow()

    var bcsSurveyList: Map<Date, Map<String, String>> = emptyMap()

    init {
        getBcs()
        getWeight()
        getBcsLevel()
    }

    private fun getBcsLevel() {
        if (bcsSurveyList.isEmpty()) {
            _bcsLevel.update {
                BcsLevel.UNKNOWN
            }
        } else {
            val bcsLevel = preferenceManager.getValue("bcs_level", "-1").toInt()
            _bcsLevel.update {
                BcsLevel.numToBcsLevel(bcsLevel)
            }
        }

    }

    private fun getBcs() {
        val petId = preferenceManager.getValue("petId", "-1L").toLong()
        if (petId == -1L) {
            bcsSurveyList = emptyMap()
        } else {
            bcsSurveyList = bcsRepository.readBcsByPet(petId = petId)
        }
    }

    private fun getWeight() {
        val newWeightList = bcsSurveyList.map() { (date, bcsSurvey) ->
            val dateFormat = SimpleDateFormat("M/d")
            val formattedDate = dateFormat.format(date)
            Pair(formattedDate, bcsSurvey["weight"]?.toDouble() ?: 0.0)
        }

        _weightList.update {
            newWeightList
        }
    }

}