package com.devforgely.lifeprotocol.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.sp
import com.devforgely.lifeprotocol.R
import com.devforgely.lifeprotocol.model.DaySchedule
import com.devforgely.lifeprotocol.model.TimeRange
import com.devforgely.lifeprotocol.ui.theme.Orange
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
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainerHigh)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            // Header
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_schedule),
                        contentDescription = null,
                        tint = Orange,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(Modifier.height(12.dp))

            schedules.forEach { daySchedule ->
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