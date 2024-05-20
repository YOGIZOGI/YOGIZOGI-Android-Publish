package org.shop.yogizogi_android_publish.ui.user.signup

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.shop.yogizogi_android_publish.R
import org.shop.yogizogi_android_publish.databinding.FragmentSignupPhoneInputBinding
import org.shop.yogizogi_android_publish.model.Resource
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
        observeViewModel()
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
            val phoneNumber = binding.tilEtPhonenum.text.toString()
            viewModel.getVerifyCode(phoneNumber)
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.phoneNumberStateFlow.collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        binding.progressBar.progress
                    }

                    is Resource.Success -> {
                        showToastMessage(result.data.description)
                        navigateToSignupCode()
                    }

                    is Resource.Error -> {

                    }
                }
            }
        }
    }

    private fun navigateToSignupCode() {
        findNavController().navigate(SignupPhoneInputFragmentDirections.actionPhoneInputFragmentToSignupCodeInputFragment())
    }
}