package org.shop.yogizogi_android_publish.ui.profile

import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.databinding.FragmentProfileTagBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class ProfileTagFragment : BaseFragment<FragmentProfileTagBinding, ProfileViewModel>(
    FragmentProfileTagBinding::inflate,
    ProfileViewModel::class.java
) {
    override fun initView() {
        initNextButton()
        initBackButton()
    }

    override fun initAfterBinding() {
        // TODO : viewModel 에서 사용자 이름과 이미지 불러오기
        // TODO : button 선택 시 viewModel에 태그 데이터 넣기
    }

    private fun initBackButton() {
        binding.includedToolbar.layoutBtnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initNextButton() {
        binding.btnNext.setOnClickListener {
            findNavController().navigate(
                ProfileTagFragmentDirections.actionProfileTagFragmentToProfileTasteFragment()
            )
        }
    }


}