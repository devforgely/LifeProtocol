package com.devforgely.lifeprotocol.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.devforgely.lifeprotocol.data.local.entity.QuestionEntity

@Dao
interface QuestionDao {
    @Query("SELECT * FROM question WHERE type = :type")
    suspend fun getQuestionsByType(type: String): List<QuestionEntity>
}