package com.devforgely.lifeprotocol.ui.notification

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class NotificationWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        val title = inputData.getString("title") ?: "Default Title"
        val message = inputData.getString("message") ?: "Default Message"

        val notifier = Notifier(applicationContext)
        notifier.showNotification(title, message)

        return Result.success()
    }
}