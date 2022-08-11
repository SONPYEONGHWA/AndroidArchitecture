package son.peace.friends.data.remote.source

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import son.peace.mypage.data.remote.api.MyPageApiService
import son.peace.mypage.data.remote.response.ResponseFollowersDto
import javax.inject.Inject


class FollowerListDataSourceImpl @Inject constructor(
    private val friendListApiService: MyPageApiService
) : FollowerListDataSource {
    override suspend fun fetchFriendList(userName: String): Flow<List<ResponseFollowersDto>> = flow {
        emit(friendListApiService.fetchFollowers(userName))
    }
}