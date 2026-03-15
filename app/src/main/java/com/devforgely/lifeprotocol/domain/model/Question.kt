package com.devforgely.lifeprotocol.domain.model

data class Question(
    val id: Int,
    val type: String,
    val content: String,
    val hint: String,
    val duration: Int
)
