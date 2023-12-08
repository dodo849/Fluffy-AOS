package com.example.fluffy_aos.data.repository

import com.example.fluffy_aos.model.pet.Pet

class PetDummy(private val repository: PetRepository) {

    fun insertDummy() {
        repository.insertPet(
            Pet(
                name = "플러피",
                species = "허스키",
                breed = "HUS",
                furType = "장모",
                age = 1,
                sex = "수컷"
            )
        )
    }
}