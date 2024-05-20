package org.shop.yogizogi_android_publish.repository

import kotlinx.coroutines.flow.Flow
import org.shop.yogizogi_android_publish.model.Resource
import org.shop.yogizogi_android_publish.model.remote.request.unauth.SignUpReqDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.CodeCheckResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.CodeSendResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.LogInResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.NicknameDupCheckResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.SignUpResDTO

interface AuthRepository {
    suspend fun login(phoneNumber: String, password: String): Flow<Resource<LogInResDTO>>

    suspend fun getVerifyCode(phoneNumber: String): Flow<Resource<CodeSendResDTO>>

    suspend fun checkVerifyCode(
        phoneNumber: String,
        code: String
    ): Flow<Resource<CodeCheckResDTO>>

    suspend fun postSignUp(body: SignUpReqDTO): Flow<Resource<SignUpResDTO>>

    suspend fun nicknameDupCheck(nickname: String): Flow<Resource<NicknameDupCheckResDTO>>
}