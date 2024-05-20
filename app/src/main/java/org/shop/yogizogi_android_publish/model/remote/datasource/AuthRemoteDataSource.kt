package org.shop.yogizogi_android.data.model.remote.datasource

import org.shop.yogizogi_android_publish.model.Resource
import org.shop.yogizogi_android_publish.model.remote.request.unauth.LogInReqDTO
import org.shop.yogizogi_android_publish.model.remote.request.unauth.SignUpReqDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.CodeCheckResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.CodeSendResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.LogInResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.NicknameDupCheckResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.SignUpResDTO

interface AuthRemoteDataSource {
    suspend fun postLogin(loginBody: LogInReqDTO): Resource<LogInResDTO>

    suspend fun getVerifyCode(phoneNumber: String): Resource<CodeSendResDTO>

    suspend fun getVerifyCheck(phoneNumber: String, code: String): Resource<CodeCheckResDTO>

    suspend fun postSignUp(body: SignUpReqDTO): Resource<SignUpResDTO>

    suspend fun getNicknameDupCheck(nickname: String): Resource<NicknameDupCheckResDTO>
}