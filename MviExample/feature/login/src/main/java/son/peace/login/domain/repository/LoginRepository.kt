package son.peace.login.domain.repository

import kotlinx.coroutines.flow.Flow
import son.peace.common.domain.UserEntity

interface LoginRepository {
    suspend fun login(userName: String): Flow<UserEntity>
}