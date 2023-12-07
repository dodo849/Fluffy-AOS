package com.example.fluffy_aos.ui.common.reusable

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.model.pet.Pet

@Composable
fun Header(
    petName: String,
    petBreed: String,
    backgroundColor: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(backgroundColor)
                .padding(vertical = 10.dp, horizontal = 20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    petName,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Black
                )
                Text(
                    petBreed,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }

        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "알림",
            modifier = Modifier.size(30.dp)
        )
    }
}