package com.example.fluffy_aos.ui.common.reusable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fluffy_aos.ui.theme.gray_outline
import com.example.fluffy_aos.ui.theme.gray_text_light
import com.example.fluffy_aos.ui.theme.main_orange

@Composable
fun RoundedOutlineSmallButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        colors = ButtonDefaults.buttonColors(Color.White),
        contentPadding = PaddingValues(
            start = 25.dp,
            end = 25.dp,
            top = 5.dp,
            bottom = 5.dp
        ),
        modifier = Modifier
            .border(
                width = 1.dp,
                color = if (isSelected) main_orange else gray_outline,
                shape = RoundedCornerShape(50.dp)
            )
            .height(30.dp)
        ,
        onClick = onClick) {
        Text(
            text = text,
            color = if (isSelected) main_orange else gray_text_light,
        )
    }
}