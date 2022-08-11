package son.peace.friends.data.remote.source

import kotlinx.coroutines.flow.Flow
import son.peace.mypage.data.remote.response.ResponseFollowersDto

interface FollowerListDataSource {
    suspend fun fetchFriendList(userName: String): Flow<List<ResponseFollowersDto>>
}