package org.shop.yogizogi_android_publish.model

sealed class Resource<T>{
    data class Loading<T>(var data:T? = null): Resource<T>()
    data class Success<T>(var data: T): Resource<T>()
    data class Error<T>(var message: String?, var data: T? = null): Resource<T>()
}