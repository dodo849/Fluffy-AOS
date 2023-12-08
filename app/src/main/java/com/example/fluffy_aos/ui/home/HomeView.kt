package com.example.fluffy_aos.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.model.pet.PetConverter
import com.example.fluffy_aos.ui.home.component.BcsDiagnosisCard
import com.example.fluffy_aos.ui.home.component.EyeDiagnosisCard
import com.example.fluffy_aos.ui.home.component.HomeHeader
import com.example.fluffy_aos.ui.home.component.SkinDiagnosisCard
import com.example.fluffy_aos.ui.home.view_model.HomeViewModel
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme
import com.example.fluffy_aos.ui.theme.page_padding

@Composable
fun HomeView(
    viewModel: HomeViewModel
) {
    val navController = LocalNavController.current

    val pet by viewModel.pet.collectAsState()

    Column(
        modifier = Modifier
            .padding(page_padding)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        HomeHeader(pet.name, pet.breed)

        BcsDiagnosisCard()

        EyeDiagnosisCard()

        SkinDiagnosisCard()

        Spacer(modifier = Modifier.padding(25.dp))
    }
}