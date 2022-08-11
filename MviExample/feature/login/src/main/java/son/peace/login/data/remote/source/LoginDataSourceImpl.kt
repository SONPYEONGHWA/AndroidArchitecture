package son.peace.login.data.remote.source

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import son.peace.login.data.remote.api.LoginApiService
import son.peace.login.data.remote.response.ResponseGetUserDto
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor(
    private val loginApiService: LoginApiService
): LoginDataSource {
    override suspend fun login(userName: String): Flow<ResponseGetUserDto> = flow {
        emit(loginApiService.getUser(userName))
    }
}