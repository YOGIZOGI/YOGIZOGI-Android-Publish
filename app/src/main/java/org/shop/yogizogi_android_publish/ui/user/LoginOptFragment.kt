package org.shop.yogizogi_android_publish.ui.user

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.shop.yogizogi_android_publish.databinding.FragmentLoginOptBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class LoginOptFragment : BaseFragment<FragmentLoginOptBinding, UserViewModel>(
    FragmentLoginOptBinding::inflate,
    UserViewModel::class.java
) {

    override fun initView() {
        viewModel.getUserInfo()

        initPhoneLogin()
        initKakaoLogin()
        initNaverLogin()
    }

    override fun initAfterBinding() {
        observeData()
    }

    private fun initPhoneLogin() {
        binding.btnPhoneLogin.setOnClickListener {
            navigateToLoginFragment()
        }
    }

    private fun initKakaoLogin() {

    }

    private fun initNaverLogin() {

    }

    private fun navigateToLoginFragment() {
        findNavController().navigate(LoginOptFragmentDirections.actionLoginOptFragmentToLoginFragment())
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
//            viewModel.userInfoStateFlow.collect { userInfo ->
//                Log.e("LoginOpt userInfo", userInfo.toString())
//                if (userInfo == null || userInfo.accessToken.isEmpty()) {
//                    Log.e("LoginOpt userInfo null", userInfo.toString())
//                    Toast.makeText(requireActivity(), "로그인이 안됨", Toast.LENGTH_SHORT).show()
//                } else {
//                    Log.e(
//                        "유저정보 - LoginFragment",
//                        "${userInfo.id}, ${userInfo.firstLogInStatus}, ${userInfo.accessToken}, ${userInfo.refreshToken}"
//                    )
//                    findNavController().popBackStack()
//                }
//            }
        }
    }
}