package com.example.fluffy_aos.ui.record

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.fluffy_aos.R
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.common.Card
import com.example.fluffy_aos.ui.record.component.RecordHeader
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme
import com.example.fluffy_aos.ui.theme.gray_background

@Composable
fun RecordView() {
    val navController = LocalNavController.current
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .background(gray_background)
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        RecordHeader()
        WeightCard()
    }
}

@Composable
fun WeightCard() {
    Card(backgroundColor = Color.White) {
        Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
            Text("체중", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Image(
                painter = painterResource(id = R.drawable.weight_graph),
                contentDescription = "Dog and Cat",
                modifier = Modifier
                    .size(350.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun RecordViewPreview() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        FluffyAOSTheme {
            RecordView()
        }
    }
}