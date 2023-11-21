package com.example.fluffy_aos.ui.bcs_diagnosis

import android.app.VoiceInteractor
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.R
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.bcs_diagnosis.component.BcsDiagnosisTitle
import com.example.fluffy_aos.ui.common.BackButton
import com.example.fluffy_aos.ui.common.Card
import com.example.fluffy_aos.ui.common.RoundedButton
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme
import com.example.fluffy_aos.ui.theme.main_orange
import kotlinx.coroutines.delay

@Composable
fun BcsDiagnosisView() {
    val navController = LocalNavController.current
    var cnt by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(25.dp, 25.dp, 25.dp, 25.dp)
    ) {
        BackButton()


        if (cnt != 5 || cnt != 6) {
            BcsDiagnosisTitle()
        }

        when (cnt) {

            0 -> BcsNumericQuestion("Q1. 흉곽 둘레를 입력해주세요") { cnt += 1 }

            1 -> BcsNumericQuestion("Q2. 목 둘레를 입력해주세요") { cnt += 1 }

            2 -> BcsNumericQuestion("Q2. 등허리 길이를 입력해주세요") { cnt += 1 }
            3 -> BcsSelectQuestion("Q3. 배변상태는 어떤가요?", listOf("정상", "문제 있음")) { cnt += 1 }
            4 -> BcsSelectQuestion(
                "Q3. 하루 식이 횟수는 몇번인가요?",
                listOf("1번", "2번", "3번", "자유급식")
            ) { cnt += 1 }

            5 -> BcsDiagnosisLoadingView() { cnt += 1 }
            6 -> BcsResultPage()

//            5 -> BcsPhotoQuestion("Q8. 정면사진을 올려주세요") {
//                cnt = 5
//            }
            // Add more cases as needed
            else -> {
                // Handle other cases or provide a default behavior
            }
        }

    }
}

@Composable
fun BcsNumericQuestion(question: String, onClickNextButton: () -> Unit = {}) {
    var text by remember { mutableStateOf("") }

    Card {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp), modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                question,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
            TextField(
                text,
                onValueChange = { text = it },
                shape = RoundedCornerShape(20.dp),
                suffix = { Text(text = "cm") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,

                    ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .border(0.dp, Color.Transparent)
            )
            RoundedButton(onClick = onClickNextButton, text = "다음으로")
        }
    }
}

@Composable
fun BcsSelectQuestion(question: String, options: List<String>, onClickNextButton: () -> Unit = {}) {

    var selectedOption by remember { mutableStateOf(0) }

    Card {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp), modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                question,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
            options.forEachIndexed { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedOption == index,
                        onClick = { selectedOption = index },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = main_orange, // 선택된 상태의 색상
                            unselectedColor = Color.Gray // 선택되지 않은 상태의 색상
                        )
                    )
                    Text("$item", fontSize = 16.sp)
                }
            }
            RoundedButton(onClick = onClickNextButton, text = "다음으로")
        }
    }
}

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

@Composable
fun BcsDiagnosisLoadingView(goNextPage: () -> Unit = {}) {
    var progressVisible by remember { mutableStateOf(true) }

    Card {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("AI 진단 중입니다", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator(
                Modifier.size(48.dp), main_orange, 3.dp
            )
        }
    }


    LaunchedEffect(Unit) {
        delay(4000L) // 3초 대기
        progressVisible = false
        goNextPage()
        // 이후에 다음 화면으로 이동하는 로직 추가
    }
}

@Composable
fun BcsResultPage() {
    Card {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(id = R.drawable.warning),
                contentDescription = "warning",
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "BCS 7단계: 과체중",
                color = main_orange,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                "척추나 꼬리 부근에 눈에 띄게" +
                        "지방이 축척 돼있고," +
                        "갈비뼈가 잘 만져지지 않고" +
                        "압력을 가했을 때 갈비뼈가 느껴지는 정도이며," +
                        "위에서 보았을 때 허리 굴곡이 거의 보이지 않는 체형입니다.",
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "체중 감량이 필요한 상태입니다",
                color = Color.Red,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BcsDiagnosisView_Preview() {
    FluffyAOSTheme {
        BcsDiagnosisView()
    }
}