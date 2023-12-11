package com.example.fluffy_aos.ui.common.header

import com.example.fluffy_aos.data.db.PreferencesManager
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

    private val _pets = MutableStateFlow<List<Pet>>(emptyList())
    val pets: StateFlow<List<Pet>> = _pets.asStateFlow()

    private val _currentPet = MutableStateFlow<Pet>(Pet.getEmptyPet())
    val currentPet: StateFlow<Pet> = _currentPet.asStateFlow()


    init {
        getPets()
    }

    fun changeCurrentPet(selectedPetId: Long) {
        preferenceManager.saveValue("petId", selectedPetId.toString())
    }


    private fun getPets() {
        val pets: List<Pet> = petRepository.readAllPets()

        _pets.update { currentState ->
            pets
        }

        val currentPetId = preferenceManager.getValue("petId", "0").toLong()

        _currentPet.update { currentState ->
            if (currentPetId != 0L) {
                pets.find { it.id == currentPetId } ?: currentState
            } else {
                currentState
            }
        }
    }
}