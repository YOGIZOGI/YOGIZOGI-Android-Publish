package org.shop.yogizogi_android_publish.ui.user.signup

import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.R
import org.shop.yogizogi_android_publish.databinding.FragmentSignupPhoneInputBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment
import org.shop.yogizogi_android_publish.ui.user.UserViewModel

@AndroidEntryPoint
class SignupPhoneInputFragment : BaseFragment<FragmentSignupPhoneInputBinding, UserViewModel>(
    FragmentSignupPhoneInputBinding::inflate,
    UserViewModel::class.java
) {
    override fun initView() {
        initToolbar()
        initRequestCode()
    }

    override fun initAfterBinding() {

    }

    private fun initToolbar() {
        with(binding) {
            includedToolbar.layoutTvTitle.text = resources.getText(R.string.signup_verify_text)
            includedToolbar.layoutBtnBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun initRequestCode() {
        binding.btnRequest.setOnClickListener {
            navigateToSignupCode()
        }
    }

    private fun navigateToSignupCode() {
        findNavController().navigate(SignupPhoneInputFragmentDirections.actionPhoneInputFragmentToSignupCodeInputFragment())
    }
}