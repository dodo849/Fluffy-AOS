package com.example.fluffy_aos.ui.common.survey.resuable

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.fluffy_aos.ui.common.reusable.RoundedButton
import com.example.fluffy_aos.ui.common.reusable.RoundedOutlineButton

@Composable
fun PhotoField(
    selectedImageUri: Uri,
    onChangeValue: (Uri) -> Unit = {}
) {

    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            val bitmap = uri?.let { /* 이미지를 비트맵으로 변환하는 로직을 추가하세요 */ }
            onChangeValue(uri ?: Uri.EMPTY)
        }


    Column {
        if (selectedImageUri != Uri.EMPTY) {
            Image(
                painter = rememberImagePainter(selectedImageUri),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp) // 이미지 크기 조절
                    .clip(shape = RoundedCornerShape(8.dp)) // 이미지를 둥근 모양으로 클립
                    .padding(4.dp) // 여백 추가
                    .clickable {
                        // 이미지 클릭 시 동작 추가
                    }
            )
        }
        RoundedOutlineButton(onClick = { launcher.launch("image/*") }, text = "사진 올리기")
    }

}