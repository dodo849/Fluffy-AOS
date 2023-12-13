package com.example.fluffy_aos.ui.setting.sub_page.my_pets.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.fluffy_aos.model.pet.Pet
import com.example.fluffy_aos.ui.setting.sub_page.my_pets.reusable.PetCard

@Composable
fun PetCardList(pets: List<Pet>, onClickDelete: (Long) -> Unit = {}) {

    var showDialog by remember() { mutableStateOf(false) }

    var deletePet by remember() { mutableStateOf<Pet?>(null) }

    pets.forEachIndexed { index, pet ->
        PetCard(
            name= pet.name,
            breed = pet.breed,
            age = "${pet.age}",
            sex = pet.sex,
            furType = pet.furType,
            onClickDelete = {
                deletePet = pet
                showDialog = true
            }
        )

        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    // 사용자가 다이얼로그 외부를 터치하여 닫을 때 호출
                    showDialog = false
                },
                title = {
                    Text(text = "반려동물 삭제")
                },
                text = {
                    Text(text = "정말로 이 반려동물(${deletePet?.name})을 삭제하시겠습니까?")
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showDialog = false
                            if (deletePet != null) {
                                onClickDelete(deletePet!!.id)
                                println("pet.id = ${deletePet!!.id}")
                            }
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