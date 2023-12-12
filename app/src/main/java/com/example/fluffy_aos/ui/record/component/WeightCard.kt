package com.example.fluffy_aos.ui.record.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.common.reusable.Card
import com.example.fluffy_aos.ui.record.reusable.rememberMarker
import com.example.fluffy_aos.ui.theme.gray_text_light
import com.example.fluffy_aos.ui.theme.main_orange
import com.patrykandpatrick.vico.compose.axis.axisGuidelineComponent
import com.patrykandpatrick.vico.compose.axis.axisLabelComponent
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.compose.chart.line.lineSpec
import com.patrykandpatrick.vico.core.axis.AxisPosition
import com.patrykandpatrick.vico.core.axis.formatter.AxisValueFormatter
import com.patrykandpatrick.vico.core.axis.formatter.DecimalFormatAxisValueFormatter
import com.patrykandpatrick.vico.core.axis.vertical.VerticalAxis
import com.patrykandpatrick.vico.core.chart.values.AxisValuesOverrider
import com.patrykandpatrick.vico.core.entry.entryModelOf
import com.patrykandpatrick.vico.core.marker.Marker
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

@Composable
fun WeightCard(weightList: List<Pair<String, Double>>) {

    val lastWeight = weightList.lastOrNull()?.second ?: 0.0

    Card(backgroundColor = Color.White) {
        Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
            WeightCardHeader(lastWeight.toString())
            WeightGraph(
                x = weightList.map {
                    it.first
                },
                y = weightList.map { it.second }
            )
//            Image(
//                painter = painterResource(id = R.drawable.weight_graph),
//                contentDescription = "Dog and Cat",
//                modifier = Modifier
//                    .size(400.dp, 240.dp)
//                    .align(Alignment.CenterHorizontally)
//            )
        }

    }
}

@Composable
private fun WeightCardHeader(weight: String) {
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
            "${weight}kg",
            fontWeight = FontWeight.Bold,
            fontSize = 34.sp
        )
    }
}

private val markerMap: Map<Float, Marker>
    @Composable get() = mapOf(
        0f to rememberMarker(),
        1f to rememberMarker(),
        2f to rememberMarker(),
        3f to rememberMarker(),
        4f to rememberMarker(),
        5f to rememberMarker(),
    )


@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun WeightGraph(x: List<String>, y: List<Double>) {

    val chartEntryModel = entryModelOf(*y.mapIndexed { index, value ->
        if (index <= 5) {
            Pair(index, value.toFloat())
        } else {
            null
        }
    }.filterNotNull().toTypedArray())

//    val chartEntryModel = entryModelOf(Pair(4, 6.5f), Pair(5, 8.1f), Pair(6, 7.3f), Pair(7, 6.9f))

    Chart(
        chart = lineChart(
            lines = listOf(
                lineSpec(lineColor = main_orange)
            ),
            axisValuesOverrider = AxisValuesOverrider.fixed(
                minY = 6f,
                maxY = 8.5f,
            ),
            persistentMarkers = markerMap,
        ),
        model = chartEntryModel,
        startAxis = rememberStartAxis(
            label = axisLabelComponent(textSize = 13.sp, color = Color.Transparent),
            guideline = axisGuidelineComponent(thickness = 0.2.dp),
            valueFormatter = DecimalFormatAxisValueFormatter("#.#"),
            horizontalLabelPosition = VerticalAxis.HorizontalLabelPosition.Inside,
            verticalLabelPosition = VerticalAxis.VerticalLabelPosition.Center
        ),
        bottomAxis = rememberBottomAxis(
            guideline = axisGuidelineComponent(thickness = 0.dp),
            valueFormatter = AxisValueFormatter() { value, _ ->
                x[value.toInt()]
            }
        ),
    )

}

