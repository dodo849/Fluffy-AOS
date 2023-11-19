package com.example.fluffy_aos.ui.home.reusable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.R
import com.example.fluffy_aos.ui.common.RoundedButton
import com.example.fluffy_aos.ui.theme.gray_background

@Composable
fun DiagnosisCardView(title: String, detail: String, imageRes: Int, onClick: () -> Unit) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(20.dp))
        .background(gray_background)
        .padding(vertical = 30.dp, horizontal = 25.dp)
    ) {
        Column (verticalArrangement = Arrangement.spacedBy(7.dp)) {
            Text(title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold)

            Text(detail,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal)

            Spacer(modifier = Modifier.padding(5.dp))
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Dog and Cat",
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.padding(5.dp))

            RoundedButton(onClick = onClick, text = "진단 시작하기")
        }
    }
}