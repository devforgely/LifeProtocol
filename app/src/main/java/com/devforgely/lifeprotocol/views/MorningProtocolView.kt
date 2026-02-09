package com.devforgely.lifeprotocol.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devforgely.lifeprotocol.R
import com.devforgely.lifeprotocol.components.ExpandingButton
import com.devforgely.lifeprotocol.components.HeaderSection
import com.devforgely.lifeprotocol.components.QuestionCard
import com.devforgely.lifeprotocol.ui.theme.Orange

@Composable
fun MorningProtocolView(progress: Float, onContinue: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                HeaderSection(R.drawable.ic_sunny, Orange,"Morning Protocol", "PHASE 1: VISION SETTING")
                Spacer(Modifier.height(28.dp))
                QuestionCard(description = "hi", textPlaceHolder = "I wake with clarity...", progress = progress)
            }
            ExpandingButton("Continue", R.drawable.ic_keyboard_arrow_right, onContinue)
        }
    }
}