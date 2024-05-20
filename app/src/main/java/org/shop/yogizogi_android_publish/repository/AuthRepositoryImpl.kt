package org.shop.yogizogi_android.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.shop.yogizogi_android.data.model.remote.datasource.AuthRemoteData
import org.shop.yogizogi_android_publish.model.Resource
import org.shop.yogizogi_android_publish.model.remote.request.unauth.LogInReqDTO
import org.shop.yogizogi_android_publish.model.remote.request.unauth.SignUpReqDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.CodeCheckResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.CodeSendResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.LogInResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.NicknameDupCheckResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.SignUpResDTO
import org.shop.yogizogi_android_publish.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authRemoteData: AuthRemoteData) :
    AuthRepository {
    override suspend fun login(phoneNumber: String, password: String): Flow<Resource<LogInResDTO>> {
        val loginBody = LogInReqDTO(phoneNumber, password)
        return flow {
            emit(authRemoteData.postLogin(loginBody))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getVerifyCode(phoneNumber: String): Flow<Resource<CodeSendResDTO>> {
        return flow {
            emit(authRemoteData.getVerifyCode(phoneNumber))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun checkVerifyCode(
        phoneNumber: String,
        code: String
    ): Flow<Resource<CodeCheckResDTO>> {
        return flow {
            emit(authRemoteData.getVerifyCheck(phoneNumber, code))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun postSignUp(body: SignUpReqDTO): Flow<Resource<SignUpResDTO>> {
        return flow {
            emit(authRemoteData.postSignUp(body))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun nicknameDupCheck(nickname: String): Flow<Resource<NicknameDupCheckResDTO>> {
        return flow {
            emit(authRemoteData.getNicknameDupCheck(nickname))
        }.flowOn(Dispatchers.IO)
    }
}