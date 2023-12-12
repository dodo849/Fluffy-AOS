package com.example.fluffy_aos.ui.common.header

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.theme.gray_background
import com.example.fluffy_aos.ui.theme.gray_background_deep
import com.example.fluffy_aos.ui.theme.page_padding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(
    viewModel: HeaderViewModel = HeaderViewModel(),
    backgroundColor: Color = gray_background,
    onPetChange: () -> Unit = {}
) {

    val currentPet by viewModel.currentPet.collectAsState()
    val pets by viewModel.pets.collectAsState()

    val sheetState = rememberModalBottomSheetState()
    var isBottomSheetVisible by remember { mutableStateOf(false) }

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
                if (currentPet.name.length == 0) {
                    Text(
                        "설정에서 반려동물을 등록해주세요",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                } else {
                    Text(
                        currentPet.name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Black
                    )
                    Text(
                        currentPet.breed,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }

        Icon(
            imageVector = Icons.Outlined.Settings,
            contentDescription = "반려동물 설정",
            modifier = Modifier
                .size(30.dp)
                .clickable(onClick = {
                    isBottomSheetVisible = true
                })
        )

        if (isBottomSheetVisible) {
            ModalBottomSheet(
                onDismissRequest = {
                    isBottomSheetVisible = false
                },
                sheetState = sheetState
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .padding(page_padding)
                ) {

                    Text(
                        "반려동물 선택",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    if (pets.isEmpty()) {
                        Text(
                            "등록된 반려동물이 없습니다. 설정탭 > 내 반려동물들에서 반려동물을 등록해주세요.",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }

                    pets.forEach {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .clickable(onClick = {
                                    viewModel.changeCurrentPet(it.id)
                                    isBottomSheetVisible = false
                                    onPetChange()
                                })
                                .background(gray_background_deep)
                                .fillMaxWidth()
                                .padding(20.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                            ) {
                            Text(it.name, fontWeight = FontWeight.Bold)
                            Text(it.breed, fontWeight = FontWeight.Normal)
                            }
                        }

                    }

                    Spacer(modifier = Modifier.padding(20.dp))
                }
            }
        }
    }
}