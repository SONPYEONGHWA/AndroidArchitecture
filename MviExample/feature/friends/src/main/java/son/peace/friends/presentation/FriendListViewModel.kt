package son.peace.friends.presentation

import son.peace.common.presentation.viewmodel.MviViewModel
import son.peace.friends.FriendListContract

class FriendListViewModel: MviViewModel<FriendListContract.FriendsIntent, FriendListContract.FriendListViewState, FriendListContract.FriendsEffect>() {


    override fun setInitialState(): FriendListContract.FriendListViewState {
        return FriendListContract.FriendListViewState()
    }

    override fun handleEvents(mviIntent: FriendListContract.FriendsIntent) {
        when(mviIntent) {
            FriendListContract.FriendsIntent.UpdateFriends -> {}
        }
    }
}