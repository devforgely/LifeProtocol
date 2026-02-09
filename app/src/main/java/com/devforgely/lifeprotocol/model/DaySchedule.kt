package com.devforgely.lifeprotocol.model

import java.time.DayOfWeek

data class DaySchedule(
    val day: DayOfWeek,
    val ranges: List<TimeRange> = emptyList()
)
