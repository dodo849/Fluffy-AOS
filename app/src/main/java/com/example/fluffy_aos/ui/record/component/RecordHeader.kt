package com.example.fluffy_aos.ui.record.component

import androidx.compose.runtime.Composable
import com.example.fluffy_aos.model.pet.Pet
import com.example.fluffy_aos.ui.common.reusable.Header
import com.example.fluffy_aos.ui.theme.gray_background_deep

@Composable
fun RecordHeader(petName: String, petBreed: String) {
    Header(
        petName = petName,
        petBreed = petBreed,
        backgroundColor = gray_background_deep
    )
}