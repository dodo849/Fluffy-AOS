package com.example.fluffy_aos.ui.bottom_navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.theme.main_orange

/// ref: https://medium.com/@bharadwaj.rns/bottom-navigation-in-jetpack-compose-using-material3-c153ccbf0593
@Composable
fun BottomNavigationBar() {
    val navController = LocalNavController.current
    val items = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Record,
        BottomNavigationItem.Post,
        BottomNavigationItem.Setting
    )
    var navigationSelectedItem by remember {
        mutableStateOf(0)
    }

    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 0.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEachIndexed {index,navigationItem ->
            NavigationBarItem(
                selected = index == navigationSelectedItem,
                label = {
                    Text(navigationItem.displayName)
                },
                icon = {
                    Icon(
                        navigationItem.icon,
                        contentDescription = navigationItem.displayName
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = main_orange,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = main_orange,
                    indicatorColor = Color.White
                ),
                onClick = {
                    navigationSelectedItem = index
                    navController.navigate(navigationItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
