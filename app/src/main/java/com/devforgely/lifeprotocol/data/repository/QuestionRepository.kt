package com.devforgely.lifeprotocol.data.repository

import com.devforgely.lifeprotocol.data.local.dao.QuestionDao
import com.devforgely.lifeprotocol.data.local.entity.QuestionEntity
import com.devforgely.lifeprotocol.domain.model.Question
import javax.inject.Inject


class QuestionRepository @Inject constructor(
    private val dao: QuestionDao
) {
    suspend fun getQuestionsByType(type: String): List<Question> {
        return dao.getQuestionsByType(type).toDomainList()
    }

    fun QuestionEntity.toDomain(): Question =
        Question(
            id = id,
            type = type,
            content = content,
            hint = hint,
            duration = duration
        )

    fun List<QuestionEntity>.toDomainList(): List<Question> =
        map { it.toDomain() }
}