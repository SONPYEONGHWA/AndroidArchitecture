package son.peace.common.domain

data class UserEntity(
    val id: String,
    val profileImage: Any,
    val name: String,
    val email: String?,
    val followerCount: Int?,
    val followingCount: Int?,
    val publicRepository: Int?
)