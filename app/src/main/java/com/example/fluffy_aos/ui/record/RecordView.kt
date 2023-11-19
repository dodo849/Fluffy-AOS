package com.example.fluffy_aos.ui.record

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.common.CardView
import com.example.fluffy_aos.ui.record.component.RecordHeader
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme
import com.example.fluffy_aos.ui.theme.gray_background

@Composable
fun RecordView() {
    val navController = LocalNavController.current
    Column(
        modifier = Modifier
            .background(gray_background)
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()) {
        RecordHeader()
        WeightCard()
    }
}

@Composable
fun WeightCard() {
    CardView {
        Text("체중")
    }
}


@Preview(showBackground = true)
@Composable
fun RecordViewPreview() {
    FluffyAOSTheme {
        RecordView()
    }
}