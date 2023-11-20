import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fluffy_aos.ui.common.RoundedOutlineSmallButton

@Composable
fun PostCategories() {
    var selectedButton by remember { mutableStateOf("반려견") }

    val categories = listOf("전체", "반려견", "반려묘", "소형동물", "파충류", "기타")

    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.horizontalScroll(rememberScrollState())
    ) {
        for (category in categories) {
            RoundedOutlineSmallButton(
                text = category,
                isSelected = selectedButton == category,
                onClick = { selectedButton = category }
            )
        }
    }
}