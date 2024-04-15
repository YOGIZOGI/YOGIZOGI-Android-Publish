package org.shop.yogizogi_android_publish.ui.user

import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.shop.yogizogi_android_publish.databinding.FragmentLoginOptBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class LoginOptFragment : BaseFragment<FragmentLoginOptBinding, UserViewModel>(
    FragmentLoginOptBinding::inflate,
    UserViewModel::class.java
) {
    override fun initView() {

    }

    override fun initAfterBinding() {
        observeData()
    }

    private fun initLoginBtn() {

    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.userInfoStateFlow.collect {
                if (it == null || it.accessToken.isEmpty()) {
                    Snackbar.make(requireView(), "로그인이 안됨", Snackbar.LENGTH_LONG).show()
                } else {
                    Log.e(
                        "유저정보 - LoginFragment",
                        "${it.id}, ${it.firstLogInStatus}, ${it.accessToken}, ${it.refreshToken}"
                    )
                    findNavController().popBackStack()
                }
            }
        }
    }
}