package org.shop.yogizogi_android_publish.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding, R : BaseViewModel>(
    private val bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> T,
    private val viewModelClass: Class<R>
) : Fragment() {

    private var _binding: T? = null

    // This property is only valid between onCreateView and onDestroyView.
    protected val binding get() = _binding!!

    lateinit var viewModel: R

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = bindingFactory.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBeforeBinding()
        initView()
        initAfterBinding()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initBeforeBinding() {
        viewModel = ViewModelProvider(requireActivity())[viewModelClass]
    }

    /**
     * initiate view and click event
     */
    abstract fun initView()

    /**
     * initiate others (ex. observe Livedata)
     */
    abstract fun initAfterBinding()
}