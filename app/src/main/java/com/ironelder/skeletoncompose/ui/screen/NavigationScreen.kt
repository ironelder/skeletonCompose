package com.ironelder.skeletoncompose.ui.screen

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ironelder.skeletoncompose.MainViewModel
import com.ironelder.skeletoncompose.getActivityViewModel

@Composable
fun NavigationScreen(
    navController: NavHostController,
    viewModel: MainViewModel = getActivityViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = { state ->
            SnackbarHost(hostState = state) { data ->
                Snackbar(actionColor = Color.White, snackbarData = data)
            }
        },
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                BottomItemType.values().forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter = rememberVectorPainter(image = screen.icon),
                                contentDescription = screen.route
                            )
                        },
                        label = { Text(screen.name) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        })
                }
            }
        }
    ) {
        CompositionLocalProvider(LocalScaffoldState provides scaffoldState) {
            NavHost(
                navController = navController,
                startDestination = BottomItemType.Upcoming.route
            ) {
                composable(BottomItemType.Upcoming.route) {
                    HomeScreen()
                }
                composable(BottomItemType.Trending.route) {
                    Text(text = "Trending")
                }
                composable(BottomItemType.Genre.route) {
                    Text(text = "Genre")
                }
            }
        }

    }
}


enum class BottomItemType(val route: String, val icon: ImageVector) {
    Upcoming("Upcoming", Icons.Filled.Favorite),
    Trending("Trending", Icons.Filled.ThumbUp),
    Genre("Genre", Icons.Filled.Star)
}

val LocalScaffoldState = compositionLocalOf<ScaffoldState> { error("Not provided scaffoldState") }