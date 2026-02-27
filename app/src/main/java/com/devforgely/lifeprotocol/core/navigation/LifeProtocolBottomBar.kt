package com.devforgely.lifeprotocol.core.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devforgely.lifeprotocol.R

@Composable
fun  LifeProtocolBottomBar(currentRoute: String?, onNavigate: (String) -> Unit) {
    NavigationBar(
        windowInsets = NavigationBarDefaults.windowInsets,
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 2.dp
    ) {
        NavigationBarItem(
            selected = currentRoute == MainDestinations.MORNING_ROUTE,
            onClick = { onNavigate(MainDestinations.MORNING_ROUTE) },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_sunny),
                    contentDescription = MainDestinations.MORNING_ROUTE,
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(26.dp)
                )
            },
            label = { Text(MainDestinations.MORNING_ROUTE) }
        )

        NavigationBarItem(
            selected = currentRoute == MainDestinations.DAY_ROUTE,
            onClick = { onNavigate(MainDestinations.DAY_ROUTE) },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_flash_on),
                    contentDescription = MainDestinations.DAY_ROUTE,
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(26.dp)
                )
            },
            label = { Text(MainDestinations.DAY_ROUTE) }
        )

        Spacer(Modifier.weight(1f))

        NavigationBarItem(
            selected = currentRoute == MainDestinations.NIGHT_ROUTE,
            onClick = { onNavigate(MainDestinations.NIGHT_ROUTE) },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_moon_stars),
                    contentDescription = MainDestinations.NIGHT_ROUTE,
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(26.dp)
                )
            },
            label = { Text(MainDestinations.NIGHT_ROUTE) }
        )

        NavigationBarItem(
            selected = currentRoute == MainDestinations.SETTING_ROUTE,
            onClick = { onNavigate(MainDestinations.SETTING_ROUTE) },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_settings),
                    contentDescription = MainDestinations.SETTING_ROUTE,
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(26.dp)
                )
            },
            label = { Text(MainDestinations.SETTING_ROUTE) }
        )
    }
}