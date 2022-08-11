package son.peace.login.domain.usecase

import kotlinx.coroutines.flow.Flow
import son.peace.common.domain.UserEntity

interface LoginUseCase {
    suspend operator fun invoke(userName: String): Flow<UserEntity>
}