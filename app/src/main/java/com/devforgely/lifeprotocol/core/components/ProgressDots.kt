package com.devforgely.lifeprotocol.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ProgressDots(length: Int, progress: Int) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(length) { index ->
            val isFilled = index < progress
            Box(
                modifier = Modifier
                    .height(7.dp)
                    .width(if (index == progress - 1) 26.dp else 7.dp)
                    .clip(RoundedCornerShape(50))
                    .background(
                        if (isFilled) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.secondary
                    )
            )
        }
    }
}