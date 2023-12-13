package com.example.fluffy_aos.ui.home.sub_page.bcs_survey.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fluffy_aos.model.bcs.BcsLevel
import com.example.fluffy_aos.ui.common.reusable.Card
import com.example.fluffy_aos.ui.theme.main_orange

@Composable
fun BcsResultPage(bcsLevel: BcsLevel) {

    Card {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "${bcsLevel.getImoji()}",
                color = main_orange,
                fontSize = 70.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "BCS ${bcsLevel.levelToNum()}단계: ${bcsLevel.getKr()}",
                color = main_orange,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                bcsLevel.getDescription(),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(Color.Red.copy(alpha = 0.1f))
                    .padding(15.dp)
            )
            {
                Text(
                    text = "⚠️ 플러피의 진단 결과는 참고용으로만 활용하시고, 정확한 진단은 수의사를 통해 받으시는 것을 권장드립니다 ",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun BcsResultPagePreview() {
    BcsResultPage(bcsLevel = BcsLevel.LEVEL_4)
}