package org.shop.yogizogi_android_publish.ui.user.signup

import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.R
import org.shop.yogizogi_android_publish.databinding.FragmentSignupPasswordInputBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment
import org.shop.yogizogi_android_publish.ui.user.UserViewModel

@AndroidEntryPoint
class SignupPasswordInputFragment : BaseFragment<FragmentSignupPasswordInputBinding, UserViewModel>(
    FragmentSignupPasswordInputBinding::inflate,
    UserViewModel::class.java
) {
    override fun initView() {
        initToolbar()
        initPasswordCheck()
    }

    override fun initAfterBinding() {

    }

    private fun initToolbar() {
        with(binding) {
            binding.includedToolbar.layoutTvTitle.text = resources.getText(R.string.signup)
            includedToolbar.layoutBtnBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun initPasswordCheck() {
        binding.btnNext.setOnClickListener {
            navigateToSignupPasswordCheck()
        }
    }

    private fun navigateToSignupPasswordCheck() {
        findNavController().navigate(SignupPasswordInputFragmentDirections.actionSignupPasswordInputFragmentToSignupPasswordCheckFragment())
    }
}