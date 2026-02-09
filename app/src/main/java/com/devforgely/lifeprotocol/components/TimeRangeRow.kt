package com.devforgely.lifeprotocol.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devforgely.lifeprotocol.R
import com.devforgely.lifeprotocol.model.TimeRange
import java.time.DayOfWeek

@Composable
fun TimeRangeRow(
    day: DayOfWeek,
    range: TimeRange,
    onRemove: () -> Unit,
    onPickTime: (DayOfWeek, String, Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(MaterialTheme.colorScheme.background)
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(18.dp))
            .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        TimeChip(range.start) { onPickTime(day, range.id, true) }

        Spacer(Modifier.width(8.dp))
        Text("–", color = MaterialTheme.colorScheme.secondary)
        Spacer(Modifier.width(8.dp))

        TimeChip(range.end) { onPickTime(day, range.id, false) }

        Spacer(Modifier.weight(1f))

        IconButton(onClick = onRemove) {
            Icon(
                painter = painterResource(R.drawable.ic_delete),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )
        }
    }
}
