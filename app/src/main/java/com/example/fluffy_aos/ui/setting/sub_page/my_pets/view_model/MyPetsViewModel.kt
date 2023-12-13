package com.example.fluffy_aos.ui.setting.sub_page.my_pets.view_model

import com.example.fluffy_aos.data.repository.PetRepository
import com.example.fluffy_aos.model.pet.Pet
import com.example.fluffy_aos.model.pet.PetConverter
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

    fun deletePet(id: Long) {
        petRepository.deletePet(id)
        getPets()
    }

    private fun getPets() {
        val foundedPets: List<Pet> = petRepository.readAllPets()

        val convertedPets: List<Pet> = foundedPets.map {
            PetConverter().codeToDescriptionByPet(it)
        }

        _pets.update {
            convertedPets
        }
    }
}