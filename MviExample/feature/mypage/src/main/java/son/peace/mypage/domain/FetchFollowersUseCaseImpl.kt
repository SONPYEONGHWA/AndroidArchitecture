package son.peace.mypage.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchFollowersUseCaseImpl @Inject constructor(
    private val followerListRepository: FollowerListRepository
) : FetchFollowersUseCase {
    override suspend fun invoke(userName: String): Flow<List<FollowerEntity>> =
        followerListRepository.fetchFriendList(userName)
}