package com.example.fluffy_aos.ui.common.question.resuable

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.theme.main_orange

@Composable
fun SelectionField(
    options: List<String>,
    initialSelected: Int,
    onValueChange: (Int) -> Unit,
) {

    var selectedOption by remember(initialSelected) { mutableStateOf(initialSelected) }

    options.forEachIndexed { index, item ->
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedOption == index,
                onClick = {
                    onValueChange(index)
                },
                colors = RadioButtonDefaults.colors(
                    selectedColor = main_orange, // 선택된 상태의 색상
                    unselectedColor = Color.Gray // 선택되지 않은 상태의 색상
                )
            )
            Text("$item", fontSize = 16.sp)
        }
    }
}