package org.shop.yogizogi_android_publish.ui.main.home

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.shop.yogizogi_android_publish.datastore.DataStoreManager
import org.shop.yogizogi_android_publish.model.local.UserInfo
import org.shop.yogizogi_android_publish.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val dataStoreManager: DataStoreManager) :
    BaseViewModel() {
    private val _userInfoStateFlow = MutableStateFlow<UserInfo?>(null)
    val userInfoStateFlow = _userInfoStateFlow.asStateFlow()

    fun getUserInfo() {
        viewModelScope.launch {
            val userInfo = dataStoreManager.getUserInfo()
            _userInfoStateFlow.value = userInfo
        }
    }
}