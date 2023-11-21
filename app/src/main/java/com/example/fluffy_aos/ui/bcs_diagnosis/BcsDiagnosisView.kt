package com.example.fluffy_aos.ui.bcs_diagnosis

import android.app.VoiceInteractor
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.bcs_diagnosis.component.BcsDiagnosisTitle
import com.example.fluffy_aos.ui.common.BackButton
import com.example.fluffy_aos.ui.common.Card
import com.example.fluffy_aos.ui.common.RoundedButton
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme
import com.example.fluffy_aos.ui.theme.main_orange

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


        BcsDiagnosisTitle()

        when (cnt) {
            0 -> BcsNumericQuestion("Q1. 흉곽 둘레를 입력해주세요") { cnt += 1 }

            1 -> BcsNumericQuestion("Q2. 목 둘레를 입력해주세요") { cnt += 1 }

            2 -> BcsNumericQuestion("Q2. 등허리 길이를 입력해주세요") { cnt += 1 }
            3 -> BcsSelectQuestion("Q3. 배변상태는 어떤가요?", listOf("정상", "문제 있음")) { cnt += 1 }
            4 -> BcsSelectQuestion("Q3. 하루 식이 횟수는 몇번인가요?", listOf("1번", "2번", "3번", "자유급식")) { cnt += 1 }
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
            Spacer(modifier = Modifier.fillMaxHeight())
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
            Spacer(modifier = Modifier.fillMaxHeight())
        }
    }
}

enum class Option {
    OPTION_1,
    OPTION_2,
    // Add more options as needed
}

@Preview(showBackground = true)
@Composable
fun BcsDiagnosisView_Preview() {
    FluffyAOSTheme {
        BcsDiagnosisView()
    }
}