package com.devforgely.lifeprotocol.ui.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devforgely.lifeprotocol.data.repository.NotificationRepository
import com.devforgely.lifeprotocol.data.repository.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val repository: UserPreferencesRepository,
    private val notificationRepository: NotificationRepository
) : ViewModel() {

    val darkMode: Flow<Boolean?> = repository.darkModeFlow

    fun setDarkMode(enabled: Boolean) {
        viewModelScope.launch {
            repository.setDarkMode(enabled)
        }
    }

    fun onScheduleClicked() {
        notificationRepository.scheduleNotification(3, "Life Protocol", "Hello World")
    }
}