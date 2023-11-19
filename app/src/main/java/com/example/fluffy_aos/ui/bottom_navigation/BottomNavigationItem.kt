package com.example.fluffy_aos.ui.bottom_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val label : String = "",
    val icon : ImageVector = Icons.Filled.Home,
    val route : String = ""
) {

    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home",
                icon = Icons.Filled.Home,
                route = BottomNavigationType.Home.route
            ),
            BottomNavigationItem(
                label = "Search",
                icon = Icons.Filled.Search,
                route = BottomNavigationType.Post.route
            ),
        )
    }
}