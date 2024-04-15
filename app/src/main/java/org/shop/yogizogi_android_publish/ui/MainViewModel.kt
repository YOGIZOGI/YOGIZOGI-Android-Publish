package org.shop.yogizogi_android_publish.ui

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.shop.yogizogi_android_publish.datastore.DataStoreManager
import org.shop.yogizogi_android_publish.model.local.LoginState
import org.shop.yogizogi_android_publish.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dataStoreManager: DataStoreManager) :
    BaseViewModel() {
    private val _authenticationState = MutableStateFlow(LoginState.NOT_LOGIN)
    val authenticationState = _authenticationState.asStateFlow()

    init {
        checkAuthentication()
    }

    private fun checkAuthentication() {
        viewModelScope.launch {
            val userInfo = dataStoreManager.getUserInfo()
            if (userInfo != null && userInfo.accessToken.isNotEmpty()) {
                _authenticationState.value = LoginState.LOGIN
            } else {
                _authenticationState.value = LoginState.NOT_LOGIN
            }
        }
    }
}