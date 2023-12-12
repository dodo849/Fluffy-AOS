package com.example.fluffy_aos.ui.record

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.fluffy_aos.data.repository.BcsRepository
import com.example.fluffy_aos.data.repository.PetRepository
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.model.bcs.BcsLevel
import com.example.fluffy_aos.ui.common.header.Header
import com.example.fluffy_aos.ui.common.reusable.Card
import com.example.fluffy_aos.ui.record.component.WeightCard
import com.example.fluffy_aos.ui.record.view_model.RecordViewModel
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme
import com.example.fluffy_aos.ui.theme.gray_background
import com.example.fluffy_aos.ui.theme.gray_background_deep
import com.example.fluffy_aos.ui.theme.gray_text_light
import com.example.fluffy_aos.ui.theme.main_orange

@Composable
fun RecordView(
    viewModel: RecordViewModel
) {

    val navController = LocalNavController.current

    val weightList by viewModel.weightList.collectAsState()
    val bcsLevel by viewModel.bcsLevel.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .background(gray_background)
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

    ) {
        Header(backgroundColor = gray_background_deep, onPetChange = {
            viewModel.onPetChange()
        })

        Text("체중", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        WeightCard(weightList = weightList)

        Spacer(modifier = Modifier.padding(5.dp))

        BcsRecordCard(bcsLevel = bcsLevel)
        Spacer(modifier = Modifier.padding(30.dp))
    }
}

@Composable
fun BcsRecordCard(bcsLevel: BcsLevel) {
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .background(gray_background)
            .fillMaxSize()
    ) {
        Text("현재 BCS", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Card(backgroundColor = Color.White) {
            Column {
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        "BCS", fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    if (bcsLevel != BcsLevel.UNKNOWN) {
                        Text(
                            "${bcsLevel.levelToNum()}단계",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = main_orange
                        )
                    }

                    Text(
                        ": ${bcsLevel.getKr()}", fontWeight = FontWeight.Bold, fontSize = 20.sp,
                        color = gray_text_light
                    )

                }
                Spacer(modifier = Modifier.padding(3.dp))
                Text(bcsLevel.getDescription())

                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    "* 플러피의 진단결과는 참고용으로만 활용하시고, 정확한 진단은 수의사와 상담하시길 바랍니다.",
                    fontWeight = FontWeight.Bold, fontSize = 13.sp,
                    color = gray_text_light
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RecordViewPreview() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        FluffyAOSTheme {
            RecordView(RecordViewModel(PetRepository(), BcsRepository()))
        }
    }
}