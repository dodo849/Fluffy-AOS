package com.example.fluffy_aos.ui.home.reusable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.common.reusable.Card
import com.example.fluffy_aos.ui.common.reusable.RoundedButton
import com.example.fluffy_aos.ui.common.reusable.RoundedButtonState

@Composable
fun DiagnosisCardView(
    title: String,
    detail: String,
    @DrawableRes imageRes: Int,
    ready: Boolean = true,
    onClick: () -> Unit
) {
    Card {
        Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
            Text(
                title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                detail,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.padding(5.dp))
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Dog and Cat",
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.padding(5.dp))

            if (ready) {
                RoundedButton(
                    text = "진단 시작하기",
                    state = RoundedButtonState.NORMAL,
                    onClick = onClick
                )
            } else {
                RoundedButton(
                    text = "준비중입니다",
                    state = RoundedButtonState.DISABLED, onClick = onClick
                )
            }
        }
    }
}