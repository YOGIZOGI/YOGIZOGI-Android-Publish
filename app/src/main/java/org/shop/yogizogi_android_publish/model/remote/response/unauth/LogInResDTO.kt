package org.shop.yogizogi_android_publish.model.remote.response.unauth

data class LogInResDTO(
    val id: String,
    val firstLogInStatus: String,
    val accessToken: String,
    val refreshToken: String
)