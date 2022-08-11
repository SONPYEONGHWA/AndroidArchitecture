package son.peace.mypage.data.remote.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import son.peace.mypage.data.mapper.FollowerMapper
import son.peace.friends.data.remote.source.FollowerListDataSource
import son.peace.mypage.domain.FollowerEntity
import son.peace.mypage.domain.FollowerListRepository
import javax.inject.Inject

class FollowerListRepositoryImpl @Inject constructor(
    private val friendListDataSource: FollowerListDataSource,
    private val friendMapper: FollowerMapper
): FollowerListRepository {
    override suspend fun fetchFriendList(userName: String): Flow<List<FollowerEntity>> =
        friendListDataSource.fetchFriendList(userName).map { followers ->
            followers.map { friendMapper.map(it) }
        }.flowOn(Dispatchers.Default)
}