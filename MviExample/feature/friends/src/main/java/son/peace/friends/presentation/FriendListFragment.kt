package son.peace.friends.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import son.peace.common.presentation.AutoClearedValue
import son.peace.friends.databinding.FragmentFriendListBinding


class FriendListFragment : Fragment() {
    private var binding by AutoClearedValue<FragmentFriendListBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentFriendListBinding.inflate(inflater, container, false).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}