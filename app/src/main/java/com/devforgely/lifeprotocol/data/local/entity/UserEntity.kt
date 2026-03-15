package com.devforgely.lifeprotocol.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val level: Int,
    val rankTitle: String,
    val currentXp: Int,
    val xpForNextLevel: Int,
    val streakDays: Int
)
