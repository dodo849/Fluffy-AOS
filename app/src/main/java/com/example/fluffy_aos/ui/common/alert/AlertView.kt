package com.example.fluffy_aos.ui.common.alert

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun KotlinWorldDialog() {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(text = "삭제하시겠습니까?")
        },
        text = {
            Text(text = "저장하신 메모가 삭제됩니다.")
        },
        confirmButton = {
            TextButton(
                onClick = {}
            ) {
                Text("확인")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {}
            ) {
                Text("취소")
            }
        }
    )
}