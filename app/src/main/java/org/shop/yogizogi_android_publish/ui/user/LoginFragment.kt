package org.shop.yogizogi_android_publish.ui.user

import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.shop.yogizogi_android_publish.databinding.FragmentLoginBinding
import org.shop.yogizogi_android_publish.model.local.UserInfo
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(
    FragmentLoginBinding::inflate,
    LoginViewModel::class.java
) {
    override fun initView() {
        initLoginBtn()
    }

    override fun initAfterBinding() {
        observeData()
    }

    private fun initLoginBtn() {
        binding.login.setOnClickListener {
            viewModel.login()
        }
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.userInfoStateFlow.collect {
                Log.e(
                    "유저 정보 - 로그인 후 LoginFragment",
                    "${it.id}, ${it.firstLogInStatus}, ${it.accessToken}, ${it.refreshToken}"
                )
                if (it == UserInfo.getDefaultInstance() || it.accessToken.isEmpty()) {
                    Snackbar.make(requireView(), "로그인이 안됨", Snackbar.LENGTH_LONG).show()
                } else {
                    findNavController().popBackStack()
                }
            }
        }
    }
}