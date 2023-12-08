package com.example.fluffy_aos.ui.setting.sub_page.my_pets.reusable

import android.graphics.Color
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.common.reusable.Card
import com.example.fluffy_aos.ui.theme.gray_text_light
import com.example.fluffy_aos.ui.theme.main_orange

@Composable
fun PetCard(
    name: String,
    breed: String,
    age: String,
    sex: String,
    furType: String,
    onClickDelete: () -> Unit = {}
) {
    Card {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
//                    modifier = Modifier.fillMaxWidth()
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
                ) {
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
                    Text(
                        "· ${furType}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }

            }
            Text(
                "삭제",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = main_orange,
                modifier = Modifier
                    .clickable { onClickDelete() }
            )
        }
    }
}