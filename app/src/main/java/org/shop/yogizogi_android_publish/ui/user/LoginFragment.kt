package org.shop.yogizogi_android_publish.ui.user

import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.databinding.FragmentLoginBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, UserViewModel>(
    FragmentLoginBinding::inflate,
    UserViewModel::class.java
) {
    override fun initView() {
        initBackBtn()
        initLoginBtn()
        initSignupBtn()
        initFindPasswordBtn()
    }

    override fun initAfterBinding() {

    }

    private fun initBackBtn() {
        binding.loginBottomsheet.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initLoginBtn() {
        binding.loginBottomsheet.btnLogin.setOnClickListener {
            navigateToProfileNickname()
        }
    }

    private fun initSignupBtn() {
        binding.loginBottomsheet.btnSignup.setOnClickListener {
            navigateToSignupPhone()
        }
    }

    private fun initFindPasswordBtn() {
        binding.loginBottomsheet.tvFindPassword.setOnClickListener {

        }
    }

    private fun navigateToSignupPhone() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToPhoneInputFragment())
    }

    private fun navigateToProfileNickname() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToProfileNicknameFragment())
    }
}