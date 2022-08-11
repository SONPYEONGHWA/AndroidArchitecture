package son.peace.mypage.presentation

import son.peace.common.domain.UserEntity
import son.peace.core.MviIntent
import son.peace.core.MviSideEffect
import son.peace.core.MviViewState
import son.peace.mypage.domain.FollowerEntity

class MyPageContract {
    sealed class MyPageIntent: MviIntent {
        data class LoadedMyInfo(val user: UserEntity): MyPageIntent()
    }

    data class MyPageState (
        override val isNetworkAvailable: Boolean = true,
        val myInfo: UserEntity? = null,
        val followerList: List<FollowerEntity> = emptyList(),
        val error: Throwable? = null
    ): MviViewState

    sealed class MyPageEffect: MviSideEffect {

    }
}