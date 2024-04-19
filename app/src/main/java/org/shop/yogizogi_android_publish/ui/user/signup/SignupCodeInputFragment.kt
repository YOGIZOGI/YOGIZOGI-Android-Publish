package org.shop.yogizogi_android_publish.ui.user.signup

import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.R
import org.shop.yogizogi_android_publish.databinding.FragmentSignupCodeInputBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment
import org.shop.yogizogi_android_publish.ui.user.UserViewModel

@AndroidEntryPoint
class SignupCodeInputFragment : BaseFragment<FragmentSignupCodeInputBinding, UserViewModel>(
    FragmentSignupCodeInputBinding::inflate,
    UserViewModel::class.java
) {
    override fun initView() {
        initToolbar()
        initRequestCodeCheck()
    }

    override fun initAfterBinding() {

    }

    private fun initToolbar() {
        with(binding) {
            includedToolbar.layoutTvTitle.text = resources.getText(R.string.verify_text)
            includedToolbar.layoutBtnBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun initRequestCodeCheck() {
        binding.btnNext.setOnClickListener {
            navigateToTermAgree()
        }
    }

    private fun navigateToTermAgree() {
        findNavController().navigate(SignupCodeInputFragmentDirections.actionSignupCodeInputFragmentToSignupTermAgreeFragment())
    }
}