package com.example.fluffy_aos.ui.bcs_diagnosis.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.common.Card
import com.example.fluffy_aos.ui.common.RoundedButton

@Composable
fun BcsNumericQuestion(
    question: String,
    suffix: String = "",
    onClickNextButton: (String) -> Unit = {},
) {
    var text by remember { mutableStateOf("") }

    Card {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp), modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                question,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
            TextField(
                text,
                onValueChange = { text = it },
                shape = RoundedCornerShape(20.dp),
                suffix = { Text(text = suffix) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,

                    ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .border(0.dp, Color.Transparent)
            )

            RoundedButton(onClick = {
                onClickNextButton(text)
                text = ""
            }, text = "다음으로")
        }
    }
}