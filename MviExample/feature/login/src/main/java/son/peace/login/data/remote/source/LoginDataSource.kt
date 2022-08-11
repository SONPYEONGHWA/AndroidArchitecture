package son.peace.login.data.remote.source

import kotlinx.coroutines.flow.Flow
import son.peace.login.data.remote.response.ResponseGetUserDto

interface LoginDataSource {
    suspend fun login(userName: String): Flow<ResponseGetUserDto>
}