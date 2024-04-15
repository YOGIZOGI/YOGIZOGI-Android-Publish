package org.shop.yogizogi_android_publish.ui.user

import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.databinding.FragmentLoginBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, UserViewModel>(
    FragmentLoginBinding::inflate,
    UserViewModel::class.java
) {
    override fun initView() {

    }

    override fun initAfterBinding() {

    }
}