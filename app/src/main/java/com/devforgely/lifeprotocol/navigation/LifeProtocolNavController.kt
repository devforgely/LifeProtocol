package com.devforgely.lifeprotocol.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


/**
 * Destinations used in the LifeProtocolApp
 */
object MainDestinations {
    const val MORNING_ROUTE = "Morning"
    const val DAY_ROUTE = "Day"
    const val PROFILE_ROUTE = "Profile"
    const val NIGHT_ROUTE = "Night"
    const val MENU_ROUTE = "Menu"
}

/**
 * Remembers and creates an instance of LifeProtocolAppNavController
 */
@Composable
fun rememberLifeProtocolNavController(navController: NavHostController = rememberNavController()): LifeProtocolNavController =
    remember(navController) {
        LifeProtocolNavController(navController)
    }

/**
 * Responsible for holding UI Navigation logic.
 */
@Stable
class LifeProtocolNavController(val navController: NavHostController) {
    // ----------------------------------------------------------
    // Navigation state source of truth
    // ----------------------------------------------------------
    fun navigateTo(route: String, from: NavBackStackEntry) {
        // Lifecycle guard
        if (!from.lifecycleIsResumed()) return

        // Avoid Navigating to same destination
        if (navController.currentDestination?.route == route) return

        navController.navigate(route) {
            // Clear the entire back stack
            popUpTo(0) {
                inclusive = true
                saveState = true
            }

            // Avoid duplicate destinations
            launchSingleTop = true

            // Restore state if it exists
            restoreState = true
        }
    }
}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 *
 * This is used to de-duplicate navigation events.
 */
private fun NavBackStackEntry.lifecycleIsResumed() = this.lifecycle.currentState == Lifecycle.State.RESUMED