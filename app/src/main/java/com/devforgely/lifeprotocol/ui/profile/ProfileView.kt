package com.devforgely.lifeprotocol.ui.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devforgely.lifeprotocol.core.components.PlayerProfileCard
import com.devforgely.lifeprotocol.domain.model.UserProfile

@Composable
fun ProfileView() {
    val userProfile = UserProfile(1, "Impulsive", 100, 200, 1)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Column {
            PlayerProfileCard(userProfile)
        }
    }
}