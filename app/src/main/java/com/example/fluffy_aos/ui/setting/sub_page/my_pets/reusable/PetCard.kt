package com.example.fluffy_aos.ui.setting.sub_page.my_pets.reusable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.common.reusable.Card
import com.example.fluffy_aos.ui.theme.gray_text_light

@Composable
fun PetCard(
    name: String,
    breed: String,
    age: String,
    sex: String
) {
    Card {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    name,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    breed,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ){
                Text(
                    "나이",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = gray_text_light
                )
                Text(
                    age,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                )
                Text(
                    "· 성별",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = gray_text_light
                )
                Text(
                    sex,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                )
            }

        }

    }
}