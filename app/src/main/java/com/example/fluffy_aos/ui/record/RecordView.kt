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
import com.example.fluffy_aos.db.PetRepository
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.common.reusable.Card
import com.example.fluffy_aos.ui.record.component.RecordHeader
import com.example.fluffy_aos.ui.record.component.WeightCard
import com.example.fluffy_aos.ui.record.view_model.RecordViewModel
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme
import com.example.fluffy_aos.ui.theme.gray_background
import com.example.fluffy_aos.ui.theme.main_orange

@Composable
fun RecordView(
    viewModel: RecordViewModel
) {

    val navController = LocalNavController.current

    val pet by viewModel.pet.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .background(gray_background)
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

    ) {
        RecordHeader(pet.name, pet.breed)

        Text("체중", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        WeightCard()
        Spacer(modifier = Modifier.padding(5.dp))

        BcsRecordCard()
        Spacer(modifier = Modifier.padding(30.dp))
    }
}

@Composable
fun BcsRecordCard() {
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
                    Text(
                        "7단계", fontWeight = FontWeight.Bold, fontSize = 20.sp,
                        color = main_orange
                    )
                }
                Spacer(modifier = Modifier.padding(3.dp))
                Text("과체중으로 약간의 체중 조절이 필요한 단계입니다. 비만이 되지 않도록 적절한 식이요법 및 운동이 필요합니다.")
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
            RecordView(RecordViewModel(PetRepository()))
        }
    }
}