package org.shop.yogizogi_android_publish.ui.user.signup

import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.R
import org.shop.yogizogi_android_publish.databinding.FragmentSignupPasswordCheckBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment
import org.shop.yogizogi_android_publish.ui.user.UserViewModel

@AndroidEntryPoint
class SignupPasswordCheckFragment : BaseFragment<FragmentSignupPasswordCheckBinding, UserViewModel>(
    FragmentSignupPasswordCheckBinding::inflate,
    UserViewModel::class.java
) {
    override fun initView() {
        initToolbar()
        initSignupComplete()
    }

    override fun initAfterBinding() {

    }

    private fun initToolbar() {
        binding.includedToolbar.layoutTvTitle.text = resources.getText(R.string.signup)
    }

    private fun initSignupComplete() {
        binding.btnComplete.setOnClickListener {
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        findNavController().navigate(SignupPasswordCheckFragmentDirections.actionSignupPasswordCheckFragmentToLoginFragment())
    }
}