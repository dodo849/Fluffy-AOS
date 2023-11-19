package com.example.fluffy_aos.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.R
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.common.CardView
import com.example.fluffy_aos.ui.common.RoundedButton
import com.example.fluffy_aos.ui.home.component.BcsDiagnosisCardView
import com.example.fluffy_aos.ui.home.component.EyeDiagnosisCardView
import com.example.fluffy_aos.ui.home.component.HomeHeader
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme

@Composable
fun HomeView() {
    val navController = LocalNavController.current
    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        HomeHeader()

        BcsDiagnosisCardView()

        Spacer(modifier = Modifier.padding(5.dp))
        EyeDiagnosisCardView()

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