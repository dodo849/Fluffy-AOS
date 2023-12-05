package com.example.fluffy_aos.db

import com.example.fluffy_aos.model.pet.Pet

class PetDummy(private val repository: PetRepository) {

    fun insertDummy() {
        repository.insertPet(
            Pet(
                name = "초코",
                species = "허스키",
                breedGroup = "허스키",
                breed = "포유류",
                furType = "장모",
                age = 1,
                sex = "수컷"
            )
        )
    }
}