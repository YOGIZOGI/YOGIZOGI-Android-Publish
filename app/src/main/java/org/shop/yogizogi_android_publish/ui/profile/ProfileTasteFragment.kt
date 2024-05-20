package org.shop.yogizogi_android_publish.ui.profile

import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.databinding.FragmentProfileTasteBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class ProfileTasteFragment : BaseFragment<FragmentProfileTasteBinding, ProfileViewModel>(
    FragmentProfileTasteBinding::inflate,
    ProfileViewModel::class.java
) {
    override fun initView() {
        initBackBtn()
        registerUser()
    }

    override fun initAfterBinding() {

    }

    private fun showHelpMessage() {
        // TODO : 몇 초간 도움말 메세지 보여주고 다시 맛 취향 선택할 수 있도록 구현

    }

    private fun initBackBtn() {
        binding.includedToolbar.layoutBtnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun registerUser() {
        binding.btnRegister.setOnClickListener {
            viewModel.login()
            // TODO 등록
            navigateToHome()
        }
    }

    private fun navigateToHome() {
        findNavController().navigate(ProfileTasteFragmentDirections.actionProfileTasteFragmentToHomeFragment())
    }
}