package com.example.fluffy_aos.ui.common.header

import com.example.fluffy_aos.data.db.PreferencesManager
import com.example.fluffy_aos.data.repository.BcsRepository
import com.example.fluffy_aos.data.repository.PetRepository
import com.example.fluffy_aos.model.pet.Pet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HeaderViewModel(
    private val petRepository: PetRepository = PetRepository(),
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
}