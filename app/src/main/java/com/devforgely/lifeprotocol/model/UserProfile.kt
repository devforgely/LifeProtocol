package com.devforgely.lifeprotocol.model

data class UserProfile(
    val level: Int,
    val rankTitle: String,
    val currentXp: Int,
    val xpForNextLevel: Int,
    val streakDays: Int
) {
    val progressFraction: Float
        get() = currentXp.toFloat() / xpForNextLevel.toFloat()
}
