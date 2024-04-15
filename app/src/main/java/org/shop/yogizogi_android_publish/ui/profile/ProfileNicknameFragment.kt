package org.shop.yogizogi_android_publish.ui.profile

import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.databinding.FragmentProfileNicknameBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class ProfileNicknameFragment : BaseFragment<FragmentProfileNicknameBinding, ProfileViewModel> (
    FragmentProfileNicknameBinding::inflate,
    ProfileViewModel::class.java,
) {
    override fun initView() {

    }

    override fun initAfterBinding() {

    }
}