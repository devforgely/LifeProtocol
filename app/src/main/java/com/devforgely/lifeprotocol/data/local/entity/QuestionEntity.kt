package com.devforgely.lifeprotocol.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question")
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: String,
    val content: String,
    val hint: String,
    val duration: Int
)
