package com.devforgely.lifeprotocol.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp

@Composable
fun HeaderSection(iconId: Int, iconColor: Color, title: String, subtitle: String) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(iconColor.copy(alpha = .15f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(iconId),
                contentDescription = "Header Icon",
                tint = iconColor
            )
        }

        Spacer(Modifier.width(12.dp))

        Column {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = Bold
            )
            Text(
                text = subtitle,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}