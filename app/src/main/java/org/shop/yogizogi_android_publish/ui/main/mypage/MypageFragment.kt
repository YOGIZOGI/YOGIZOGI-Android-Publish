package org.shop.yogizogi_android_publish.ui.main.mypage

import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.databinding.FragmentMypageBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class MypageFragment : BaseFragment<FragmentMypageBinding, MypageViewModel>(
    FragmentMypageBinding::inflate,
    MypageViewModel::class.java
) {
    override fun initView() {

    }

    override fun initAfterBinding() {

    }

}