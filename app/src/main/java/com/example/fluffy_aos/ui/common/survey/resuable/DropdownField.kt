package com.example.fluffy_aos.ui.common.survey.resuable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.theme.main_orange

@Composable
fun DropdownField(
    options: List<String>,
    initialSelected: Int,
    onValueChange: (Int) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(initialSelected) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(20.dp)
            .clickable {
                expanded = !expanded
            }
    ) {
        Text("${options[selectedOption]}", fontSize = 16.sp)
        Icon(
            imageVector = Icons.Default.ArrowDropDown, // 화살표 아이콘
            contentDescription = null,
            tint = Color.Black, // 화살표 아이콘 색상
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterEnd)
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(Color.White)

        ) {
            options.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = { Text("$item") },
                    onClick = {
                        selectedOption = index
                        onValueChange(index)
                        expanded = false
                    },
                )
            }
        }
    }
}