package son.peace.login.data.remote.source

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.test.graphql.UserQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import son.peace.login.data.remote.api.LoginApiService
import son.peace.login.data.remote.response.ResponseGetUserDto
import java.lang.IllegalArgumentException
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor(
    private val apolloClient: ApolloClient
): LoginDataSource {
    override suspend fun login(userName: String): Flow<ApolloResponse<UserQuery.Data>> = flow {
//        emit(loginApiService.getUser(userName))
        apolloClient.query(UserQuery(userName)).execute().let {
            emit(it)
        }
    }
}