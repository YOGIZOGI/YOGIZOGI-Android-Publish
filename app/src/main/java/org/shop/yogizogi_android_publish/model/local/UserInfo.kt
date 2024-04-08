package org.shop.yogizogi_android_publish.model.local

import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(
    val id: String,
    val firstLogInStatus: String,
    val accessToken: String,
    val refreshToken: String
){
    companion object {
        fun getDefaultInstance() = UserInfo(
            id = "",
            firstLogInStatus = "",
            accessToken = "",
            refreshToken = ""
        )
    }
}
