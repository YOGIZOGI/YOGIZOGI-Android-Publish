package org.shop.yogizogi_android_publish.ui.user

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.shop.yogizogi_android_publish.datastore.DataStoreManager
import org.shop.yogizogi_android_publish.model.Resource
import org.shop.yogizogi_android_publish.model.local.UserInfo
import org.shop.yogizogi_android_publish.model.remote.response.unauth.CodeSendResDTO
import org.shop.yogizogi_android_publish.repository.AuthRepository
import org.shop.yogizogi_android_publish.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val dataStoreManager: DataStoreManager, private val authRepository: AuthRepository) :
    BaseViewModel() {
    private val _userInfoStateFlow = MutableStateFlow<UserInfo?>(null)
    val userInfoStateFlow = _userInfoStateFlow.asStateFlow()

    private val _phoneNumberStateFlow = MutableStateFlow<Resource<CodeSendResDTO>>(Resource.Loading())
    val phoneNumberStateFlow = _phoneNumberStateFlow.asStateFlow()

    fun getUserInfo() {
        viewModelScope.launch {
            val userInfo = dataStoreManager.getUserInfo()
            Log.e("UserViewModel UserInfo", userInfo.toString())
            _userInfoStateFlow.value = userInfo
        }
    }

    fun getVerifyCode(phoneNum: String){
        viewModelScope.launch {
            authRepository.getVerifyCode(phoneNum).collect{
                _phoneNumberStateFlow.value = it
            }
        }
    }
}