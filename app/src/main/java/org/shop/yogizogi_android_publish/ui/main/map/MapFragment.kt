package org.shop.yogizogi_android_publish.ui.main.map

import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.databinding.FragmentMapBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class MapFragment : BaseFragment<FragmentMapBinding, MapViewModel>(
    FragmentMapBinding::inflate,
    MapViewModel::class.java
) {
    override fun initView() {

    }

    override fun initAfterBinding() {

    }

}