package org.shop.yogizogi_android_publish.ui.main.bookmark

import dagger.hilt.android.AndroidEntryPoint
import org.shop.yogizogi_android_publish.databinding.FragmentBookmarkBinding
import org.shop.yogizogi_android_publish.ui.base.BaseFragment

@AndroidEntryPoint
class BookmarkFragment : BaseFragment<FragmentBookmarkBinding, BookmarkViewModel>(
    FragmentBookmarkBinding::inflate,
    BookmarkViewModel::class.java
) {
    override fun initView() {

    }

    override fun initAfterBinding() {

    }

}