package com.example.fluffy_aos.ui.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.setting.component.SettingList
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme

@Composable
fun SettingView() {
    val navController = LocalNavController.current

    val survey: MutableMap<String, Any> = mutableMapOf()

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Text(
            "설정",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )
        Spacer(modifier = Modifier.padding(10.dp))
        SettingList(
            items = listOf(
                Pair("내 반려동물들", "my_pets"),
                Pair("설정", "setting_detail"),
            )
        )
    }

//
//    Row {
//        Text("준비중입니다")
//
//        Button(onClick = {
//            navController.navigate("onboarding_survey")
//        }) {
//            Text("온보딩 페이지 테스트")
//        }
//
//        Button(onClick = {
//            DbManager.resetDatabase()
//        }) {
//            Text("DB 초기화")
//        }
//    }
}

@Preview(showBackground = true)
@Composable
fun SettingViewPreview() {
    FluffyAOSTheme {
        SettingView()
    }
}