package com.example.fluffy_aos.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.common.CardView


@Composable
fun Header() {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CardView {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("초코",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold)
                Text("비글",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal)
            }
        }
        Text("설정") // TODO: add icon
    }
}
