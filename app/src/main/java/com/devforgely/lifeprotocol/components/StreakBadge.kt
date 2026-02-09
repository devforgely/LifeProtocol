package com.devforgely.lifeprotocol.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devforgely.lifeprotocol.R
import com.devforgely.lifeprotocol.ui.theme.DarkOrange

@Composable
fun StreakBadge(days: Int) {
    val streakOrange = DarkOrange.copy(alpha = 0.12f)

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(streakOrange)
            .padding(horizontal = 14.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_mode_heat),
            contentDescription = null,
            tint = DarkOrange,
            modifier = Modifier.size(24.dp)
        )

        Spacer(Modifier.width(6.dp))

        Text(
            text = "$days Day Streak",
            color = DarkOrange,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp
        )
    }
}