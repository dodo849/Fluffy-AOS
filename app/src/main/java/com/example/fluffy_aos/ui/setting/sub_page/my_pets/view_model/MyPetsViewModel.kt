package com.example.fluffy_aos.ui.setting.sub_page.my_pets.view_model

import com.example.fluffy_aos.db.PetRepository
import com.example.fluffy_aos.model.pet.Pet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyPetsViewModel(
    val petRepository: PetRepository
) {

    private val _pets = MutableStateFlow<List<Pet>>(emptyList())
    val pets: StateFlow<List<Pet>> = _pets.asStateFlow()

    init {
        getPets()
    }

    private fun getPets() {
        val newPets: List<Pet> = petRepository.readAllPets()

        _pets.update { currentState ->
            currentState + newPets
        }
    }
}