package org.shop.yogizogi_android_publish.ui.user

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.shop.yogizogi_android_publish.datastore.DataStoreManager
import org.shop.yogizogi_android_publish.model.local.UserInfo
import org.shop.yogizogi_android_publish.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val dataStoreManager: DataStoreManager) :
    BaseViewModel() {
    private val _userInfoStateFlow = MutableStateFlow<UserInfo?>(null)
    val userInfoStateFlow = _userInfoStateFlow.asStateFlow()

    fun login() {
        viewModelScope.launch {
            dataStoreManager.saveUserInfo("asdf", "inactive", "qwerty", "zxcvbn")
            val user = dataStoreManager.userInfoFlow.first()
            _userInfoStateFlow.value = user ?: UserInfo.getDefaultInstance()
        }
    }
}