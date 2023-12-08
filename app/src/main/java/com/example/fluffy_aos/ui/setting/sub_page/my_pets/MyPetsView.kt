package com.example.fluffy_aos.ui.setting.sub_page.my_pets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.common.reusable.BackButton
import com.example.fluffy_aos.ui.common.reusable.RoundedOutlineButton
import com.example.fluffy_aos.ui.setting.sub_page.my_pets.component.PetCardList
import com.example.fluffy_aos.ui.setting.sub_page.my_pets.view_model.MyPetsViewModel

@Composable
fun MyPetsView(
    viewModel: MyPetsViewModel
) {
    val navController = LocalNavController.current

    val pets by viewModel.pets.collectAsState()

    var showDialog by remember() { mutableStateOf(false) }
    var deletePetId by remember() { mutableStateOf(-1L) }

    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        BackButton()

        PetCardList(pets = pets, onClickDelete = {
            showDialog = true
            deletePetId = it
        })

        RoundedOutlineButton(text = "반려동물 추가하기") {
            navController.navigate("onboarding_survey")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    // 사용자가 다이얼로그 외부를 터치하여 닫을 때 호출
                    showDialog = false
                },
                title = {
                    Text(text = "펫 삭제")
                },
                text = {
                    Text(text = "정말로 이 펫을 삭제하시겠습니까?")
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showDialog = false
                            viewModel.deletePet(deletePetId)
                        }
                    ) {
                        Text("삭제")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            showDialog = false
                        }
                    ) {
                        Text("취소")
                    }
                }
            )
        }

    }
}