package org.shop.yogizogi_android_publish.ui.main.setting

import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.databinding.FragmentSettingBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class SettingFragment : BaseFragment<FragmentSettingBinding, SettingViewModel>(
    FragmentSettingBinding::inflate,
    SettingViewModel::class.java
) {
    override fun initView() {

    }

    override fun initAfterBinding() {

    }

}