package org.shop.yogizogi_android_publish.ui.profile

import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.databinding.FragmentProfileTagBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class ProfileTagFragment : BaseFragment<FragmentProfileTagBinding, ProfileViewModel>(
    FragmentProfileTagBinding::inflate,
    ProfileViewModel::class.java
) {
    override fun initView() {

    }

    override fun initAfterBinding() {

    }
}