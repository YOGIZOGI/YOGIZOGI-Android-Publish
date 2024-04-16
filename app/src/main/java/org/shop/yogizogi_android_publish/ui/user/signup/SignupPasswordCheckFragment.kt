package org.shop.yogizogi_android_publish.ui.user.signup

import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.databinding.FragmentSignupPasswordCheckBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment
import org.shop.yogizogi_android_publish.ui.user.UserViewModel

@AndroidEntryPoint
class SignupPasswordCheckFragment : BaseFragment<FragmentSignupPasswordCheckBinding, UserViewModel>(
    FragmentSignupPasswordCheckBinding::inflate,
    UserViewModel::class.java
) {
    override fun initView() {

    }

    override fun initAfterBinding() {

    }
}