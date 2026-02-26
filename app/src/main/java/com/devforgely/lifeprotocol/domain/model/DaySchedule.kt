package com.devforgely.lifeprotocol.domain.model

import java.time.DayOfWeek

data class DaySchedule(
    val day: DayOfWeek,
    val ranges: List<TimeRange> = emptyList()
)
