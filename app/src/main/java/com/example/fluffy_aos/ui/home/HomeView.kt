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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.home.component.BcsDiagnosisCard
import com.example.fluffy_aos.ui.home.component.EyeDiagnosisCard
import com.example.fluffy_aos.ui.home.component.HomeHeader
import com.example.fluffy_aos.ui.home.component.SkinDiagnosisCard
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme

@Composable
fun HomeView() {
    val navController = LocalNavController.current
    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        HomeHeader()

        BcsDiagnosisCard()

        EyeDiagnosisCard()

        SkinDiagnosisCard()

        Button(onClick = { navController.navigate("post") }) {
            Text("Go to Post")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeView_Preview() {
    FluffyAOSTheme {
        HomeView()
    }
}