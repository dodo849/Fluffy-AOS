package com.example.fluffy_aos.ui.bcs_diagnosis.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.R
import com.example.fluffy_aos.ui.common.Card
import com.example.fluffy_aos.ui.theme.main_orange


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