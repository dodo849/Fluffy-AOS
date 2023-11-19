package com.example.fluffy_aos.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.common.CardView
import com.example.fluffy_aos.ui.common.RoundedButton
import com.example.fluffy_aos.ui.home.component.Header
import com.example.fluffy_aos.ui.home.reusable.DiagnosisCardView
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme

@Composable
fun HomeView() {
    val navController = LocalNavController.current
    Column(modifier = Modifier.padding(20.dp)) {
        Header()
        BcsDiagnosisCardView()
        Button(onClick = { navController.navigate("post") }) {
            Text("Go to Post")
        }
    }
}

@Composable
fun BcsDiagnosisCardView() {
    DiagnosisCardView {
        Column {
            Text("AI BCS 진단",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(5.dp))
            Text("가정에서 측정할 수 있는 수치로 BCS를 진단해드려요. 다양한 각도에서 찍은 사진을 첨부한다면 더욱 정확해진답니다!",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal)
            Spacer(modifier = Modifier.padding(5.dp))
            RoundedButton(onClick = { /*TODO*/ }, text = "진단 시작하기")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun HomeView_Preview() {
    FluffyAOSTheme {
        HomeView()
    }
}