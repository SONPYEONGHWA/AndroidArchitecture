package son.peace.mypage.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Path
import son.peace.mypage.data.remote.response.ResponseFollowersDto

interface MyPageApiService {
    @GET("/users/{username}/followers")
    suspend fun fetchFollowers(@Path("username") username: String): List<ResponseFollowersDto>
}