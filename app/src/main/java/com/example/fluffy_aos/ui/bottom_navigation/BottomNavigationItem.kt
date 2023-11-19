package com.example.fluffy_aos.ui.bottom_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(val route: String, val displayName: String, val icon: ImageVector) {
    object Home : BottomNavigationItem("home", "홈", Icons.Filled.Home)
    object Post : BottomNavigationItem("post", "포스팅", Icons.Filled.Person)
}