package son.peace.login.domain.usecase

import kotlinx.coroutines.flow.Flow
import son.peace.common.domain.UserEntity
import son.peace.login.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    private val loginRepository: LoginRepository
) : LoginUseCase {
    override suspend fun invoke(userName: String): Flow<UserEntity> = loginRepository.login(userName)
}