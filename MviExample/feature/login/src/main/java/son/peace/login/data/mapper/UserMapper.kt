package son.peace.login.data.mapper

import com.test.graphql.UserQuery
import son.peace.core.BaseMapper
import son.peace.login.data.remote.response.ResponseGetUserDto
import son.peace.common.domain.UserEntity

class UserMapper: BaseMapper<UserQuery.User, UserEntity> {
    override fun map(from: UserQuery.User): UserEntity  {
        return UserEntity(
            from.id,
            from.avatarUrl,
            from.name ?: "",
            from.email,
            from.followers.nodes?.size,
            from.following.nodes?.size,
            from.repositories.nodes?.size
        )
    }
}