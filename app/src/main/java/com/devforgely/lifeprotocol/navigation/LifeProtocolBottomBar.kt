package com.devforgely.lifeprotocol.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.devforgely.lifeprotocol.R
import com.devforgely.lifeprotocol.components.NavItem

@Composable
fun  LifeProtocolBottomBar(currentRoute: String?, onNavigate: (String) -> Unit) {
    BottomAppBar(
        actions = {
            NavItem(
                selected = currentRoute == MainDestinations.MORNING_ROUTE,
                icon_id = R.drawable.ic_sunny,
                label = MainDestinations.MORNING_ROUTE,
                onClick = { onNavigate(MainDestinations.MORNING_ROUTE) }
            )

            NavItem(
                selected = currentRoute == MainDestinations.DAY_ROUTE,
                icon_id = R.drawable.ic_flash_on,
                label = MainDestinations.DAY_ROUTE,
                onClick = { onNavigate(MainDestinations.DAY_ROUTE) }
            )

            Spacer(Modifier.weight(1f))

            NavItem(
                selected = currentRoute == MainDestinations.NIGHT_ROUTE,
                icon_id = R.drawable.ic_moon_stars,
                label = MainDestinations.NIGHT_ROUTE,
                onClick = { onNavigate(MainDestinations.NIGHT_ROUTE) }
            )

            NavItem(
                selected = currentRoute == MainDestinations.MENU_ROUTE,
                icon_id = R.drawable.ic_settings,
                label = MainDestinations.MENU_ROUTE,
                onClick = { onNavigate(MainDestinations.MENU_ROUTE) }
            )
        }
    )
}