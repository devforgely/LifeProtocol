package com.devforgely.lifeprotocol.data.repository



import android.content.Context
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.devforgely.lifeprotocol.ui.notification.NotificationWorker
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class NotificationRepository @Inject constructor(
    @param:ApplicationContext private val context: Context
) {
    fun scheduleNotification(delaySeconds: Long, title: String, message: String) {
        val data = workDataOf(
            "title" to title,
            "message" to message
        )

        val notificationWork = OneTimeWorkRequestBuilder<NotificationWorker>()
            .setInitialDelay(delaySeconds, TimeUnit.SECONDS)
            .setInputData(data)
            .build()

        WorkManager.getInstance(context).enqueueUniqueWork(
            "notification_work_${System.currentTimeMillis()}",
            ExistingWorkPolicy.REPLACE,
            notificationWork
        )
    }
}