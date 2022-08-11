package son.peace.mypage.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import son.peace.common.presentation.DiffCallback
import son.peace.mypage.BR
import son.peace.mypage.databinding.ItemFollowerBinding
import son.peace.mypage.domain.FollowerEntity

class FollowerListAdapter: ListAdapter<FollowerEntity, FollowerListAdapter.FollowersViewHolder>(
    DiffCallback<FollowerEntity>()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowersViewHolder {
        val binding = ItemFollowerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowersViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.apply {
            setVariable(BR.data, item)
        }
    }

    class FollowersViewHolder(val binding: ItemFollowerBinding): RecyclerView.ViewHolder(binding.root)
}