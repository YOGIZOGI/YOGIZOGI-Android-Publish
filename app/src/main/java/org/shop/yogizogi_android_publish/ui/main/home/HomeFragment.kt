package org.shop.yogizogi_android_publish.ui.main.home

import android.util.Log
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.shop.yogizogi_android_publish.databinding.FragmentHomeBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate,
    HomeViewModel::class.java
) {
    override fun initView() {
        viewModel.getUserInfo()
    }

    override fun initAfterBinding() {
        observeUserInfo()
    }

    private fun observeUserInfo() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.userInfoStateFlow.collect { userInfo ->
                if (userInfo != null) {
                    Log.e(
                        "유저정보 - HomeFragment",
                        "${userInfo.id}, ${userInfo.firstLogInStatus}, ${userInfo.accessToken}, ${userInfo.refreshToken}"
                    )
                }
            }
        }
    }
}