package org.shop.yogizogi_android.data.model.remote.datasource

import org.shop.yogizogi_android_publish.api.AuthService
import org.shop.yogizogi_android_publish.model.Resource
import org.shop.yogizogi_android_publish.model.remote.processCall
import org.shop.yogizogi_android_publish.model.remote.request.unauth.LogInReqDTO
import org.shop.yogizogi_android_publish.model.remote.request.unauth.SignUpReqDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.CodeCheckResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.CodeSendResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.LogInResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.NicknameDupCheckResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.SignUpResDTO
import javax.inject.Inject

class AuthRemoteData @Inject constructor(private val authService: AuthService) :
    AuthRemoteDataSource {
    override suspend fun postLogin(loginBody: LogInReqDTO): Resource<LogInResDTO> {
        return processCall { authService.postLogin(loginBody) }
    }

    override suspend fun getVerifyCode(phoneNumber: String): Resource<CodeSendResDTO> {
        return processCall { authService.getVerifyCode(phoneNumber) }
    }

    override suspend fun getVerifyCheck(
        phoneNumber: String, code: String
    ): Resource<CodeCheckResDTO> {
        return processCall { authService.getCodeCheck(phoneNumber, code) }
    }

    override suspend fun postSignUp(body: SignUpReqDTO): Resource<SignUpResDTO> {
        return processCall { authService.postSignUp(body) }
    }

    override suspend fun getNicknameDupCheck(nickname: String): Resource<NicknameDupCheckResDTO> {
        return processCall { authService.getNicknameDupCheck(nickname) }
    }
}