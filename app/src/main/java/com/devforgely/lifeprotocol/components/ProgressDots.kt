package com.devforgely.lifeprotocol.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ProgressDots(length: Int, progress: Float) {
    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
        repeat(length) { index ->
            val filled = index < (progress * length).toInt()
            Box(
                modifier = Modifier
                    .height(6.dp)
                    .width(if (index == 0) 26.dp else 6.dp)
                    .clip(RoundedCornerShape(50))
                    .background(
                        if (filled) MaterialTheme.colorScheme.surfaceTint
                        else MaterialTheme.colorScheme.onSurface
                    )
            )
        }
    }
}