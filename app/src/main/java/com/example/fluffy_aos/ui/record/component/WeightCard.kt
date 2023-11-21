package com.example.fluffy_aos.ui.record.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.R
import com.example.fluffy_aos.ui.common.Card
import com.example.fluffy_aos.ui.theme.gray_text_light
import com.example.fluffy_aos.ui.theme.main_orange
import com.patrykandpatrick.vico.compose.axis.axisGuidelineComponent
import com.patrykandpatrick.vico.compose.axis.axisTickComponent
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.endAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.compose.chart.line.lineSpec
import com.patrykandpatrick.vico.core.chart.line.LineChart
import com.patrykandpatrick.vico.core.entry.entryModelOf

@Composable
fun WeightCard() {
    Card(backgroundColor = Color.White) {
        Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
            WeightCardHeader("10.6kg")
//            WeightGraph()
            Image(
                painter = painterResource(id = R.drawable.weight_graph),
                contentDescription = "Dog and Cat",
                modifier = Modifier
                    .size(400.dp, 240.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

    }
}

@Composable
fun WeightCardHeader(weight: String) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                "최근",
                fontWeight = FontWeight.Bold,
                color = gray_text_light,
                fontSize = 18.sp
            )
            Text(
                "전체보기 >",
                fontWeight = FontWeight.Bold,
                color = gray_text_light,
                fontSize = 14.sp
            )
        }
        Text(
            weight,
            fontWeight = FontWeight.Bold,
            fontSize = 34.sp
        )
    }

}

@Composable
fun WeightGraph() {
    val chartEntryModel = entryModelOf(6.5f, 8.1f, 7.3f, 6.9f)
    Chart(
        chart = lineChart(
            lines = listOf(
                lineSpec(lineColor = main_orange)
            )
        ),
        model = chartEntryModel,
        startAxis = rememberStartAxis(guideline = axisGuidelineComponent(thickness = 0.5.dp)),
        bottomAxis = rememberBottomAxis(guideline = axisGuidelineComponent(thickness = 0.dp)),
    )
}