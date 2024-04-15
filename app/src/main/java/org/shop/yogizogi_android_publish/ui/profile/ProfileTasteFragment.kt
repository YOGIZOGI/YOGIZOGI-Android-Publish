package org.shop.yogizogi_android_publish.ui.profile

import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.databinding.FragmentProfileTasteBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class ProfileTasteFragment :BaseFragment<FragmentProfileTasteBinding,ProfileViewModel> (
    FragmentProfileTasteBinding::inflate,
    ProfileViewModel::class.java
){
    override fun initView() {

    }

    override fun initAfterBinding() {

    }
}