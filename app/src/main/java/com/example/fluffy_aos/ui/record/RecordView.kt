package com.example.fluffy_aos.ui.record

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme

@Composable
fun RecordView() {
    Text(
        text = "Hello zz!",
    )
}

@Preview(showBackground = true)
@Composable
fun RecordViewPreview() {
    FluffyAOSTheme {
        RecordView()
    }
}