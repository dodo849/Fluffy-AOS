package com.example.fluffy_aos.ui.home.sub_page.bcs_survey.component

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.ui.common.reusable.Card
import com.example.fluffy_aos.ui.common.reusable.RoundedButton

@Composable
fun BcsPhotoQuestion(question: String, setState: () -> Unit = {}) {
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            val bitmap = uri?.let { /* 이미지를 비트맵으로 변환하는 로직을 추가하세요 */ }
            setState()
        }

    // 갤러리 열기 버튼
    Card {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp), modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                question,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
            RoundedButton(onClick = { launcher.launch("image/*") }, text = "사진 올리기")
        }
    }
}