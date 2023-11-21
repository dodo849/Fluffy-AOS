package com.example.fluffy_aos.ui.record

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.fluffy_aos.ui.record.component.WeightCard
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme
import com.example.fluffy_aos.ui.theme.gray_background
import com.example.fluffy_aos.ui.theme.gray_text_light

@Composable
fun RecordView() {
    val navController = LocalNavController.current
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .background(gray_background)
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

    ) {
        RecordHeader()

        Text("체중", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        WeightCard()
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