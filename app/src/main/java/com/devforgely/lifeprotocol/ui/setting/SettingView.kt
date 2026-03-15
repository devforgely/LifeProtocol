package com.devforgely.lifeprotocol.ui.setting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devforgely.lifeprotocol.R
import com.devforgely.lifeprotocol.core.components.HeaderSection
import com.devforgely.lifeprotocol.core.components.ToggleSettingCard
import com.devforgely.lifeprotocol.core.components.WeeklyScheduleCard
import com.devforgely.lifeprotocol.core.theme.Blue
import com.devforgely.lifeprotocol.core.theme.Red


@Composable
fun SettingView(isDarkMode: Boolean, onDarkModeChange: (Boolean) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Column {
            HeaderSection(R.drawable.ic_settings, MaterialTheme.colorScheme.primary, "Settings", "ADJUST PREFERENCES")
            Spacer(Modifier.height(28.dp))

            ToggleSettingCard("Random Awareness",
                "The app will randomly ping you to answer questions.",
                R.drawable.ic_gpp_maybe,
                Red,
                true,
                {}
            )

            Spacer(Modifier.height(14.dp))

            ToggleSettingCard(
                "Dark Mode",
                description = "",
                iconId = R.drawable.ic_dark_mode,
                Blue,
                enabled = isDarkMode,
                onToggle = onDarkModeChange
            )

            Spacer(Modifier.height(14.dp))

            WeeklyScheduleCard("Focus Shield",
                "During this window, pattern-breaking alerts are suppressed to allow for Deep Work.",
                emptyList(),
                onSchedulesChange = {},
                onPickTime = { _, _, _ -> }
            )
        }
    }
}