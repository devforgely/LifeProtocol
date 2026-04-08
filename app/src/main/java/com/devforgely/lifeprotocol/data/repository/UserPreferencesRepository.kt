package com.devforgely.lifeprotocol.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.devforgely.lifeprotocol.data.local.UserPreferencesKeys
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferencesRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    // ---- READ ----
    val darkModeFlow: Flow<Boolean?> = dataStore.data
        .map { prefs ->
            prefs[UserPreferencesKeys.DARK_MODE]
        }

    // ---- WRITE ----
    suspend fun setDarkMode(enabled: Boolean) {
        dataStore.edit { prefs ->
            prefs[UserPreferencesKeys.DARK_MODE] = enabled
        }
    }

    suspend fun clearAll() {
        dataStore.edit { it.clear() }
    }
}
