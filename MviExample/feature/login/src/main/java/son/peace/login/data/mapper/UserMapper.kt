package son.peace.login.data.mapper

import son.peace.core.BaseMapper
import son.peace.login.data.remote.response.ResponseGetUserDto
import son.peace.common.domain.UserEntity

class UserMapper: BaseMapper<ResponseGetUserDto, UserEntity> {
    override fun map(from: ResponseGetUserDto): UserEntity =
        UserEntity(
            from.id ?: -1,
            from.avatar_url ?: "",
            from.name ?: "",
            from.email,
            from.followers,
            from.following,
            from.public_repos
        )
}