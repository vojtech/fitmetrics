package com.fediim.fitmetrics.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.fediim.fitmetrics.domain.model.FitBitAuthToken
import java.time.Instant
import javax.inject.Inject
import kotlinx.coroutines.flow.firstOrNull

class TokenDataStore @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    companion object {
        private val ACCESS_TOKEN = stringPreferencesKey("access_token")
        private val REFRESH_TOKEN = stringPreferencesKey("refresh_token")
        private val EXPIRES_IN = longPreferencesKey("expires_in")
        private val TOKEN_TYPE = stringPreferencesKey("token_type")
        private val SCOPE = stringPreferencesKey("scope")
        private val CREATED_AT = longPreferencesKey("created_at")
    }

    suspend fun saveToken(token: FitBitAuthToken) {
        dataStore.edit { preferences ->
            preferences[ACCESS_TOKEN] = token.accessToken
            preferences[REFRESH_TOKEN] = token.refreshToken
            preferences[EXPIRES_IN] = token.expiresIn
            preferences[TOKEN_TYPE] = token.tokenType
            preferences[SCOPE] = token.scope
            preferences[CREATED_AT] = token.createdAt.epochSecond
        }
    }

    suspend fun getToken(): FitBitAuthToken? {
        return dataStore.data.firstOrNull()?.let { preferences ->
            val accessToken = preferences[ACCESS_TOKEN] ?: return null
            val refreshToken = preferences[REFRESH_TOKEN] ?: return null
            val expiresIn = preferences[EXPIRES_IN] ?: return null
            val tokenType = preferences[TOKEN_TYPE] ?: return null
            val scope = preferences[SCOPE] ?: return null
            val createdAt = preferences[CREATED_AT]?.let {
                Instant.ofEpochSecond(
                    it
                )
            } ?: return null

            FitBitAuthToken(
                accessToken = accessToken,
                refreshToken = refreshToken,
                expiresIn = expiresIn,
                tokenType = tokenType,
                scope = scope,
                createdAt = createdAt
            )
        }
    }

    suspend fun clearToken() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}
