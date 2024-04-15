package org.shop.yogizogi_android_publish.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import org.shop.yogizogi_android_publish.model.local.UserInfo
import org.shop.yogizogi_android_publish.utils.dataStore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreManager @Inject constructor(@ApplicationContext context: Context) {
    private val dataStore = context.dataStore

    companion object {
        val UUID_KEY = stringPreferencesKey("uuid")
        val FIRST_LOGIN_STATUS_KEY = stringPreferencesKey("firstLoginStatus")
        val ACCESS_TOKEN_KEY = stringPreferencesKey("accessToken")
        val REFRESH_TOKEN_KEY = stringPreferencesKey("refreshToken")
    }

    suspend fun saveUserInfo(
        uuid: String,
        firstLoginStatus: String,
        accessToken: String,
        refreshToken: String
    ) {
        dataStore.edit { preferences ->
            preferences[UUID_KEY] = uuid
            preferences[FIRST_LOGIN_STATUS_KEY] = firstLoginStatus
            preferences[ACCESS_TOKEN_KEY] = accessToken
            preferences[REFRESH_TOKEN_KEY] = refreshToken
        }
    }

    suspend fun getUserInfo(): UserInfo? {
        val preferences = dataStore.data.first()
        val uuid = preferences[UUID_KEY] ?: return null
        val firstLoginStatus = preferences[FIRST_LOGIN_STATUS_KEY] ?: return null
        val accessToken = preferences[ACCESS_TOKEN_KEY] ?: return null
        val refreshToken = preferences[REFRESH_TOKEN_KEY] ?: return null
        return UserInfo(uuid, firstLoginStatus, accessToken, refreshToken)
    }

    val userInfoFlow: Flow<UserInfo?> = dataStore.data.map { preferences ->
        val uuid = preferences[UUID_KEY] ?: return@map null
        val firstLoginStatus = preferences[FIRST_LOGIN_STATUS_KEY] ?: return@map null
        val accessToken = preferences[ACCESS_TOKEN_KEY] ?: return@map null
        val refreshToken = preferences[REFRESH_TOKEN_KEY] ?: return@map null
        UserInfo(uuid, firstLoginStatus, accessToken, refreshToken)
    }
}