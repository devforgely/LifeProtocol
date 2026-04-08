package com.devforgely.lifeprotocol.ui

import androidx.lifecycle.ViewModel
import com.devforgely.lifeprotocol.data.repository.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class LifeProtocolAppViewModel @Inject constructor(
    private val repository: UserPreferencesRepository
) : ViewModel() {

    val darkMode: Flow<Boolean?> = repository.darkModeFlow

}