package com.devforgely.lifeprotocol.model

import java.time.LocalTime
import java.util.UUID

data class TimeRange(
    val id: String = UUID.randomUUID().toString(),
    val start: LocalTime,
    val end: LocalTime
)
