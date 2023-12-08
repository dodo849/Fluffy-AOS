package com.example.fluffy_aos.ui.setting.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import com.example.fluffy_aos.ui.setting.reusable.SettingListItem
@Composable
fun SettingList(items: List<Pair<String, String>>) {
    Column {
        items.forEachIndexed { index, item ->
            SettingListItem(
                title = item.first,
                destinationPageName = item.second
            )
            if (index < items.size - 1) {
                Divider()
            }
        }
    }

}