package com.example.fluffy_aos.ui.common.header

import com.example.fluffy_aos.data.db.PreferencesManager
import com.example.fluffy_aos.data.repository.PetRepository
import com.example.fluffy_aos.model.pet.Pet
import com.example.fluffy_aos.model.pet.PetConverter
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
        val foundedPets: List<Pet> = petRepository.readAllPets()

        val convertedPets: List<Pet> = foundedPets.map {
            PetConverter().codeToDescriptionByPet(it)
        }

        _pets.update { currentState ->
            convertedPets
        }

        val currentPetId = preferenceManager.getValue("petId", "0").toLong()
        val foundedCurrentPet = convertedPets.find { it.id == currentPetId }

        foundedCurrentPet?.let {
            _currentPet.update { foundedCurrentPet }
        }

    }
}