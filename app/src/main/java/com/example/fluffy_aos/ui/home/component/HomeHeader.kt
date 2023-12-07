package com.example.fluffy_aos.ui.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.model.pet.Pet
import com.example.fluffy_aos.ui.common.reusable.Header
import com.example.fluffy_aos.ui.theme.gray_background


@Composable
fun HomeHeader(petName: String, petBreed: String) {
    Header(
        petName = petName,
        petBreed = petBreed,
        backgroundColor = gray_background
    )
}
