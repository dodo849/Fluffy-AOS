package com.example.fluffy_aos.ui.common.survey.resuable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun StringField(
    text: String,
    onValueChange: (String) -> Unit,
) {
    val focusRequester = remember { FocusRequester() }

    TextField(
        text,
        onValueChange = {
            onValueChange(it)
        },
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,

            ),
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .border(0.dp, Color.Transparent)
            .focusRequester(focusRequester)
    )
    // Trigger focus when the composable is first laid out
    DisposableEffect(Unit) {
        focusRequester.requestFocus()
        onDispose { }
    }

}