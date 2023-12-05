package com.example.fluffy_aos.ui.bcs_diagnosis.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.common.Card
import com.example.fluffy_aos.ui.common.RoundedButton
import com.example.fluffy_aos.ui.theme.main_orange

@Composable
fun BcsSelectQuestion(
    question: String,
    options: List<String>,
    onClickNextButton: (Int) -> Unit = {}
) {

    var selectedOption by remember { mutableStateOf(0) }

    Card {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp), modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                question,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
            options.forEachIndexed { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedOption == index,
                        onClick = { selectedOption = index },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = main_orange, // 선택된 상태의 색상
                            unselectedColor = Color.Gray // 선택되지 않은 상태의 색상
                        )
                    )
                    Text("$item", fontSize = 16.sp)
                }
            }
            RoundedButton(onClick = {
                onClickNextButton(selectedOption)
                selectedOption = 0
            }, text = "다음으로")
        }
    }
}