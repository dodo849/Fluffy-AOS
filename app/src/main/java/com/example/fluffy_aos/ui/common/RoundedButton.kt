package com.example.fluffy_aos.ui.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.theme.main_orange
import com.example.fluffy_aos.ui.theme.main_orange_light

@Composable
fun RoundedButton(onClick: () -> Unit, text: String) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(main_orange_light),
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(
            start = 20.dp,
            end = 20.dp,
            top = 20.dp,
            bottom = 20.dp
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text,
            color = main_orange,
            fontWeight = FontWeight(600),
            fontSize = 18.sp
        )
    }
}