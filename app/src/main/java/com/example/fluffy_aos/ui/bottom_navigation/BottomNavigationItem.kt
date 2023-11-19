package com.example.fluffy_aos.ui.bottom_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(val route: String, val displayName: String, val icon: ImageVector) {
    object Home : BottomNavigationItem("home", "홈", Icons.Filled.Home)
    object Record : BottomNavigationItem("record", "기록", Icons.Filled.Create)
    object Post : BottomNavigationItem("post", "포스팅", Icons.Filled.List)
    object Setting : BottomNavigationItem("setting", "설정", Icons.Filled.Settings)
}