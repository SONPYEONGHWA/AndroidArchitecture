package son.peace.login.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Path
import son.peace.login.data.remote.response.ResponseGetUserDto

interface LoginApiService {
    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): ResponseGetUserDto
}