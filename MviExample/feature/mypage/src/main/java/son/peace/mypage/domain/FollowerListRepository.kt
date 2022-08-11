package son.peace.mypage.domain

import kotlinx.coroutines.flow.Flow

interface FollowerListRepository {
    suspend fun fetchFriendList(userName: String): Flow<List<FollowerEntity>>
}