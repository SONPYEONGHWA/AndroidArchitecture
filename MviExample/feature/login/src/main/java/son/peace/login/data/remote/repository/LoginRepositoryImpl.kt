package son.peace.login.data.remote.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import son.peace.login.data.mapper.UserMapper
import son.peace.login.data.remote.source.LoginDataSource
import son.peace.common.domain.UserEntity
import son.peace.login.domain.repository.LoginRepository
import javax.inject.Inject


class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource,
    private val userMapper: UserMapper
): LoginRepository {
    override suspend fun login(userName: String): Flow<UserEntity> =
        loginDataSource.login(userName).map {
            userMapper.map(it)
        }.flowOn(Dispatchers.Default)
}