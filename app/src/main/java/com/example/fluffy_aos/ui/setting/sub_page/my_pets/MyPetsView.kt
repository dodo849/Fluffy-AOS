package com.example.fluffy_aos.ui.setting.sub_page.my_pets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fluffy_aos.ui.common.reusable.BackButton
import com.example.fluffy_aos.ui.setting.sub_page.my_pets.component.PetCardList
import com.example.fluffy_aos.ui.setting.sub_page.my_pets.view_model.MyPetsViewModel

@Composable
fun MyPetsView(
    viewModel: MyPetsViewModel
) {

    val pets by viewModel.pets.collectAsState()

    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        BackButton()

        PetCardList(pets = pets)
    }
}