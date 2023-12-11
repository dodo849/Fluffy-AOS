package com.example.fluffy_aos.ui.record.view_model

import android.preference.PreferenceManager
import com.example.fluffy_aos.data.db.PreferencesManager
import com.example.fluffy_aos.data.repository.BcsRepository
import com.example.fluffy_aos.data.repository.PetRepository
import com.example.fluffy_aos.model.pet.Pet
import com.example.fluffy_aos.model.pet.PetConverter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecordViewModel(
    private val petRepository: PetRepository,
    private val bcsRepository: BcsRepository,
    private val preferenceManager: PreferencesManager = PreferencesManager,
) {

    private val _pet = MutableStateFlow<Pet>(Pet.getEmptyPet())
    val pet: StateFlow<Pet> = _pet.asStateFlow()

    init {
        getPet()
    }
    private fun getPet() {

        val pets: List<Pet> = petRepository.readAllPets()

        _pet.update { currentState ->
            val latestPet = pets.lastOrNull()
            println("Latest pet: $latestPet")
            latestPet ?: currentState
        }
    }

    private fun getBcs() {
        val bcs = bcsRepository.readBcsByPet(petId = pet.value.id)
        println("BCS: $bcs")
    }
}