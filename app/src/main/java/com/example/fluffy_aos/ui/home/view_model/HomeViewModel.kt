package com.example.fluffy_aos.ui.home.view_model

import com.example.fluffy_aos.data.repository.PetRepository
import com.example.fluffy_aos.model.pet.Pet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel(
    private val petRepository: PetRepository
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