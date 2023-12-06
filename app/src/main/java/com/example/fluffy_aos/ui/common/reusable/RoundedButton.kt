package com.example.fluffy_aos.ui.common.reusable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.theme.gray_text_light
import com.example.fluffy_aos.ui.theme.main_orange
import com.example.fluffy_aos.ui.theme.main_orange_light
import com.example.fluffy_aos.ui.theme.main_yellow
import com.example.fluffy_aos.ui.theme.main_yellow_light


enum class RoundedButtonState {
    NORMAL,
    DISABLED,
    SECONDARY,
}

@Composable
fun RoundedButton(
    text: String,
    state: RoundedButtonState = RoundedButtonState.NORMAL,
    onClick: () -> Unit,
) {

    val backgroundColor = when (state) {
        RoundedButtonState.NORMAL -> main_orange_light
        RoundedButtonState.DISABLED -> Color.LightGray
        RoundedButtonState.SECONDARY -> main_yellow_light
    }
    val contentColor = when (state) {
        RoundedButtonState.NORMAL -> main_orange
        RoundedButtonState.DISABLED -> gray_text_light
        RoundedButtonState.SECONDARY -> main_yellow
    }

    Button(
        onClick = onClick,
        enabled = state != RoundedButtonState.DISABLED,
        colors = ButtonDefaults.buttonColors(backgroundColor),
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
            color = contentColor,
            fontWeight = FontWeight(600),
            fontSize = 18.sp
        )
    }
}