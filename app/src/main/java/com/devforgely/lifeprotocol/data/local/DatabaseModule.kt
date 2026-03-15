package com.devforgely.lifeprotocol.data.local

import android.content.Context
import com.devforgely.lifeprotocol.data.local.dao.QuestionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    fun provideQuestionDao(database: AppDatabase): QuestionDao {
        return database.questionDao()
    }
}