package com.devforgely.lifeprotocol.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.devforgely.lifeprotocol.R
import com.devforgely.lifeprotocol.core.navigation.LifeProtocolBottomBar
import com.devforgely.lifeprotocol.core.navigation.MainDestinations
import com.devforgely.lifeprotocol.core.navigation.rememberLifeProtocolNavController
import com.devforgely.lifeprotocol.core.theme.LifeProtocolTheme
import com.devforgely.lifeprotocol.ui.dayprotocol.DayProtocolView
import com.devforgely.lifeprotocol.ui.morningprotocol.MorningProtocolView
import com.devforgely.lifeprotocol.ui.nightprotocol.NightProtocolView
import com.devforgely.lifeprotocol.ui.profile.ProfileView
import com.devforgely.lifeprotocol.ui.setting.SettingView

@Preview
@Composable
fun LifeProtocolApp() {
    val isSystemInDarkTheme = isSystemInDarkTheme()
    var isDarkMode by rememberSaveable {
        mutableStateOf(isSystemInDarkTheme)
    }

    LifeProtocolTheme(
        darkTheme = isDarkMode
    ) {
        val lifeProtocolNavController = rememberLifeProtocolNavController()
        val navController = lifeProtocolNavController.navController

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(R.mipmap.background),
                    contentScale = ContentScale.Crop
                ),
            containerColor = Color.Transparent,
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
            floatingActionButtonPosition = FabPosition.Center,
            bottomBar = { LifeProtocolBottomBar(
                currentRoute = currentRoute,
                onNavigate = { route ->
                    navBackStackEntry?.let { entry ->
                        lifeProtocolNavController.navigateTo(route, entry)
                    }
                }
            )}
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = MainDestinations.PROFILE_ROUTE,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(MainDestinations.MORNING_ROUTE) { MorningProtocolView() }
                composable(MainDestinations.DAY_ROUTE) { DayProtocolView() }
                composable(MainDestinations.PROFILE_ROUTE) { ProfileView() }
                composable(MainDestinations.NIGHT_ROUTE) { NightProtocolView() }
                composable(MainDestinations.SETTING_ROUTE) { SettingView(
                    isDarkMode = isDarkMode,
                    onDarkModeChange = { isDarkMode = it }
                )}
            }
        }
    }
}
