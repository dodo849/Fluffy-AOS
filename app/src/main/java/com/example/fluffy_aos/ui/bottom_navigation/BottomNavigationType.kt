package com.example.fluffy_aos.ui.bottom_navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.fluffy_aos.R

sealed class BottomNavigationType(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Home : BottomNavigationType("home", R.string.home, Icons.Filled.Home)
    object Post : BottomNavigationType("post", R.string.post, Icons.Filled.Person)
}