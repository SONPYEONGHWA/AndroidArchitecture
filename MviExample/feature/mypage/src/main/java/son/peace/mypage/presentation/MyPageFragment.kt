package son.peace.mypage.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import son.peace.common.presentation.AutoClearedValue
import son.peace.common.presentation.RecyclerviewItemDivider
import son.peace.common.presentation.RecyclerviewItemDivider.Companion.IS_HORIZONTAL
import son.peace.common.domain.UserEntity
import son.peace.common.extenstions.collectWhenStarted
import son.peace.mypage.databinding.FragmentMyPageBinding

@AndroidEntryPoint
class MyPageFragment: Fragment() {
    private var binding by AutoClearedValue<FragmentMyPageBinding>()
    private val myPageViewModel by viewModels<MyPageViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMyPageBinding.inflate(inflater, container, false).let {
        binding = it
        binding.myPageViewModel = myPageViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerviewFollowers.run {
            adapter = FollowerListAdapter()
            addItemDecoration(RecyclerviewItemDivider(5, 0, IS_HORIZONTAL))
        }
        render()
        requireActivity().intent.getStringExtra("USER_ENTITY")?.let {
            myPageViewModel.emitIntent(MyPageContract.MyPageIntent.LoadedMyInfo(
                Gson().fromJson(it, UserEntity::class.java))
            )
        }
    }

    private fun render() {
        collectWhenStarted(myPageViewModel.uiState) {
            (binding.recyclerviewFollowers.adapter as FollowerListAdapter).submitList(it.followerList)
        }
    }
}