package org.shop.yogizogi_android_publish.ui.user.signup

import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.R
import org.shop.yogizogi_android_publish.databinding.FragmentSignupTermAgreeBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment
import org.shop.yogizogi_android_publish.ui.user.UserViewModel

@AndroidEntryPoint
class SignupTermAgreeFragment : BaseFragment<FragmentSignupTermAgreeBinding, UserViewModel>(
    FragmentSignupTermAgreeBinding::inflate,
    UserViewModel::class.java
) {
    override fun initView() {
        initToolbar()
        initPasswordInput()
    }

    override fun initAfterBinding() {

    }

    private fun initToolbar() {
        with(binding) {
            binding.includedToolbar.layoutTvTitle.text = resources.getText(R.string.signup_agree)
            includedToolbar.layoutBtnBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun initPasswordInput() {
        binding.btnSignup.setOnClickListener {
            navigateToSignupPasswordInput()
        }
    }

    private fun navigateToSignupPasswordInput() {
        findNavController().navigate(SignupTermAgreeFragmentDirections.actionSignupTermAgreeFragmentToSignupPasswordInputFragment())
    }
}