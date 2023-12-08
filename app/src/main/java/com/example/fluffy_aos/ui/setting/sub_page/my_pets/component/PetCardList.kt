package com.example.fluffy_aos.ui.setting.sub_page.my_pets.component

import androidx.compose.runtime.Composable
import com.example.fluffy_aos.model.pet.Pet
import com.example.fluffy_aos.ui.setting.sub_page.my_pets.reusable.PetCard

@Composable
fun PetCardList(pets: List<Pet>, onClickDelete: (Long) -> Unit = {}) {
    pets.forEachIndexed { index, pet ->
        PetCard(
            name= pet.name,
            breed = pet.breed,
            age = "${pet.age}",
            sex = pet.sex,
            furType = pet.furType,
            onClickDelete = { onClickDelete(pet.id) }
        )
    }

}