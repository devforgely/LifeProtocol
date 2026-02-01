package com.devforgely.lifeprotocol

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.devforgely.lifeprotocol.navigation.LifeProtocolBottomBar
import com.devforgely.lifeprotocol.navigation.MainDestinations
import com.devforgely.lifeprotocol.navigation.rememberLifeProtocolNavController
import com.devforgely.lifeprotocol.ui.theme.LifeProtocolTheme
import com.devforgely.lifeprotocol.views.DayView
import com.devforgely.lifeprotocol.views.MenuView
import com.devforgely.lifeprotocol.views.MorningView
import com.devforgely.lifeprotocol.views.NightView
import com.devforgely.lifeprotocol.views.ProfileView

@Preview
@Composable
fun LifeProtocolApp() {
    LifeProtocolTheme {
        val lifeProtocolNavController = rememberLifeProtocolNavController()
        val navController = lifeProtocolNavController.navController

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        Scaffold(
            bottomBar = { LifeProtocolBottomBar(
                currentRoute = currentRoute,
                onNavigate = { route ->
                    navBackStackEntry?.let { entry ->
                        lifeProtocolNavController.navigateTo(route, entry)
                    }
                }
            )},
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { navBackStackEntry?.let { entry ->
                        lifeProtocolNavController.navigateTo(MainDestinations.PROFILE_ROUTE, entry)
                    }},
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    shape = CircleShape,
                    modifier = Modifier.size(72.dp).offset(y = (70).dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_trophy),
                        contentDescription = MainDestinations.PROFILE_ROUTE,
                        modifier = Modifier.size(40.dp)
                    )
                }
            },
            floatingActionButtonPosition = FabPosition.Center
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = MainDestinations.PROFILE_ROUTE,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(MainDestinations.MORNING_ROUTE) { MorningView() }
                composable(MainDestinations.DAY_ROUTE) { DayView() }
                composable(MainDestinations.PROFILE_ROUTE) { ProfileView() }
                composable(MainDestinations.NIGHT_ROUTE) { NightView() }
                composable(MainDestinations.MENU_ROUTE) { MenuView() }
            }
        }
    }
}
