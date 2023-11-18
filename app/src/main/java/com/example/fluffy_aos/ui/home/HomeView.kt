package com.example.fluffy_aos.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.base.gray_background
import com.example.fluffy_aos.ui.home.component.Header
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme

@Composable
fun HomeView() {
    val navController = LocalNavController.current
    Column {
        Header()
        DiagnosisCardView()
        Button(onClick = { navController.navigate("post") }) {
            Text("Go to Post")
        }
    }
}

@Composable
fun DiagnosisCardView() {
    Column(modifier = Modifier.padding(15.dp)) {
        Text("AI BCS 진단",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold)
        Text("가정에서 측정할 수 있는 수치로 BCS를 진단해드려요. 다양한 각도에서 찍은 사진을 첨부한다면 더욱 정확해진답니다!",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal)

    }
}



@Preview(showBackground = true)
@Composable
fun HomeView_Preview() {
    FluffyAOSTheme {
        HomeView()
    }
}