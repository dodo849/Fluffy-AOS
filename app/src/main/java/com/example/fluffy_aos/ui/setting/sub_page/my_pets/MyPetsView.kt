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
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.common.reusable.BackButton
import com.example.fluffy_aos.ui.common.reusable.RoundedButton
import com.example.fluffy_aos.ui.common.reusable.RoundedOutlineButton
import com.example.fluffy_aos.ui.setting.sub_page.my_pets.component.PetCardList
import com.example.fluffy_aos.ui.setting.sub_page.my_pets.view_model.MyPetsViewModel

@Composable
fun MyPetsView(
    viewModel: MyPetsViewModel
) {
    val navController = LocalNavController.current

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

        RoundedOutlineButton(text = "반려동물 추가하기") {
            navController.navigate("onboarding_survey")
        }
    }
}