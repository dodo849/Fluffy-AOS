package com.example.fluffy_aos.ui.bottom_navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.fluffy_aos.global.LocalNavController

@Composable
fun BottomNavigationBar() {
    val navController = LocalNavController.current
    val items = BottomNavigationItem().bottomNavigationItems()
    var navigationSelectedItem by remember {
        mutableStateOf(0)
    }

    NavigationBar(
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        BottomNavigationItem().bottomNavigationItems().forEachIndexed {index,navigationItem ->
            NavigationBarItem(
                selected = index == navigationSelectedItem,
                label = {
                    Text(navigationItem.label)
                },
                icon = {
                    Icon(
                        navigationItem.icon,
                        contentDescription = navigationItem.label
                    )
                },
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
