package com.devforgely.lifeprotocol.core.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devforgely.lifeprotocol.R
import com.devforgely.lifeprotocol.core.theme.Orange
import com.devforgely.lifeprotocol.domain.model.DaySchedule
import com.devforgely.lifeprotocol.domain.model.TimeRange
import java.time.DayOfWeek
import java.time.LocalTime

@Composable
fun WeeklyScheduleCard(
    title: String,
    note: String = "",
    schedules: List<DaySchedule>,
    onSchedulesChange: (List<DaySchedule>) -> Unit,
    onPickTime: (day: DayOfWeek, rangeId: String, isStart: Boolean) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.elevatedCardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Header
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_schedule),
                        contentDescription = null,
                        tint = Orange,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(Modifier.width(16.dp))

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold
                )
            }

            schedules.forEachIndexed { index, daySchedule ->
                if (index > 0) {
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 8.dp),
                        thickness = 0.5.dp,
                        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                    )
                }

                DaySection(
                    schedule = daySchedule,
                    onAddRange = {
                        val updated = schedules.updateDay(daySchedule.day) {
                            it + TimeRange(
                                start = LocalTime.of(9, 0),
                                end = LocalTime.of(17, 0)
                            )
                        }
                        onSchedulesChange(updated)
                    },
                    onRemoveRange = { id ->
                        val updated = schedules.updateDay(daySchedule.day) {
                            it.filterNot { r -> r.id == id }
                        }
                        onSchedulesChange(updated)
                    },
                    onPickTime = onPickTime
                )
            }

            Spacer(Modifier.height(12.dp))

            if (note.isNotBlank()) {
                Spacer(Modifier.height(16.dp))
                InfoBox(note)
            }
        }
    }
}

private fun List<DaySchedule>.updateDay(
    day: DayOfWeek,
    update: (List<TimeRange>) -> List<TimeRange>
): List<DaySchedule> {
    return map {
        if (it.day == day) it.copy(ranges = update(it.ranges)) else it
    }
}