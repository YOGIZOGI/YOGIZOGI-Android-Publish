package org.shop.yogizogi_android_publish.ui.profile

import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.databinding.FragmentProfileNicknameBinding
import org.shop.yogizogi_android_publish.databinding.FragmentProfileTagBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class ProfileNicknameFragment : BaseFragment<FragmentProfileNicknameBinding, ProfileViewModel>(
    FragmentProfileNicknameBinding::inflate,
    ProfileViewModel::class.java,
) {
    override fun initView() {
        initNextBtn()
    }

    override fun initAfterBinding() {
        // TODO
    }


    private fun initNextBtn() {
        binding.btnNext.setOnClickListener {
            // TODO : 닉네밍 비었을 때 예외 처리, 닉네임 중복 처리

        }
    }

    private fun initBackBtn() {
        // TODO : Fragment 이동
    }

    private fun navigateToProfileTag() {
        findNavController().navigate(
            ProfileNicknameFragmentDirections.actionProfileNicknameFragmentToProfileTagFragment()
        )
    }
}