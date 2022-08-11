package son.peace.friends

import son.peace.core.MviIntent
import son.peace.core.MviSideEffect
import son.peace.core.MviViewState

class FriendListContract {
    sealed class FriendsIntent: MviIntent {
        object UpdateFriends: FriendsIntent()
    }

    data class FriendListViewState(
        override val isNetworkAvailable: Boolean = true,
        val friendList: List<String> = emptyList()
    ): MviViewState

    sealed class FriendsEffect(): MviSideEffect {
        object NavigateToFriendDetail: FriendsEffect()
    }
}