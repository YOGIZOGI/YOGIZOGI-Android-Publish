package org.shop.yogizogi_android_publish.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.shop.yogizogi_android_publish.R
import org.shop.yogizogi_android_publish.databinding.ActivityMainBinding
import org.shop.yogizogi_android_publish.model.local.LoginState

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    private val noneBnvFragment = listOf(
        R.id.loginFragment
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        initBottomNavigationView()
        observeAuthenticationState()
    }

    private fun initBottomNavigationView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_main) as NavHostFragment
        binding.mainBnv.setupWithNavController(navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in noneBnvFragment) {
                binding.mainBnv.visibility = View.GONE
            } else {
                binding.mainBnv.visibility = View.VISIBLE
            }
        }
    }

    private fun observeAuthenticationState() {
        val navController =
            (supportFragmentManager.findFragmentById(R.id.fragment_container_main) as NavHostFragment).navController
        lifecycleScope.launch {
            mainViewModel.authenticationState.collect { authState ->
                if (authState == LoginState.NOT_LOGIN) {
                    navController.navigate(R.id.loginFragment)
                } else if (authState == LoginState.LOGIN) {
                    navController.navigate(R.id.homeFragment)
                }
            }
        }
    }
}