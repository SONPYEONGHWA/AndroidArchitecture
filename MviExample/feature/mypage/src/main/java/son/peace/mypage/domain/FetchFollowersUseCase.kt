package son.peace.mypage.domain

import kotlinx.coroutines.flow.Flow

interface FetchFollowersUseCase {
    suspend operator fun invoke(userName: String): Flow<List<FollowerEntity>>
}