package com.devforgely.lifeprotocol.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devforgely.lifeprotocol.model.DaySchedule
import java.time.DayOfWeek

@Composable
fun DaySection(
    schedule: DaySchedule,
    onAddRange: () -> Unit,
    onRemoveRange: (String) -> Unit,
    onPickTime: (DayOfWeek, String, Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                schedule.day.name.lowercase().replaceFirstChar { it.uppercase() },
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            TextButton(onClick = onAddRange) {
                Text("+ Add", color = MaterialTheme.colorScheme.onSurface)
            }
        }

        Spacer(Modifier.height(8.dp))

        schedule.ranges.forEach { range ->
            TimeRangeRow(
                day = schedule.day,
                range = range,
                onRemove = { onRemoveRange(range.id) },
                onPickTime = onPickTime
            )
            Spacer(Modifier.height(8.dp))
        }

        if (schedule.ranges.isEmpty()) {
            Text(
                "No focus windows",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 13.sp
            )
        }
    }
}
