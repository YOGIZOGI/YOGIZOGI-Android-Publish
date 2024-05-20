package org.shop.yogizogi_android_publish.api

import org.shop.yogizogi_android_publish.model.remote.request.unauth.LogInReqDTO
import org.shop.yogizogi_android_publish.model.remote.request.unauth.SignUpReqDTO
import org.shop.yogizogi_android_publish.model.remote.response.CommonSuccessRes
import org.shop.yogizogi_android_publish.model.remote.response.unauth.CodeCheckResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.CodeSendResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.LogInResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.NicknameDupCheckResDTO
import org.shop.yogizogi_android_publish.model.remote.response.unauth.SignUpResDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthService {
    @POST("api/auth/login")
    suspend fun postLogin(@Body loginBody: LogInReqDTO): Response<CommonSuccessRes<LogInResDTO>>

    @GET("/api/verification/code")
    suspend fun getVerifyCode(@Query("phoneNumber") phoneNumber: String): Response<CommonSuccessRes<CodeSendResDTO>>

    @GET("/api/verification/check")
    suspend fun getCodeCheck(
        @Query("phoneNumber") phoneNumber: String,
        @Query("code") code: String
    ): Response<CommonSuccessRes<CodeCheckResDTO>>

    @POST("/api/sign-up")
    suspend fun postSignUp(@Body signUpReq: SignUpReqDTO): Response<CommonSuccessRes<SignUpResDTO>>

    @GET("/api/sign-up/check-duplication-nickname")
    suspend fun getNicknameDupCheck(@Query("nickname") nickname: String): Response<CommonSuccessRes<NicknameDupCheckResDTO>>
}