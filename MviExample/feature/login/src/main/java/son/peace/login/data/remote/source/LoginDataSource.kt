package son.peace.login.data.remote.source

import com.apollographql.apollo3.api.ApolloResponse
import com.test.graphql.UserQuery
import kotlinx.coroutines.flow.Flow
import son.peace.login.data.remote.response.ResponseGetUserDto

interface LoginDataSource {
    suspend fun login(userName: String): Flow<ApolloResponse<UserQuery.Data>>
}