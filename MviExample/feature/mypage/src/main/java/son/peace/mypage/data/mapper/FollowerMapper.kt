package son.peace.mypage.data.mapper

import son.peace.core.BaseMapper
import son.peace.mypage.data.remote.response.ResponseFollowersDto
import son.peace.mypage.domain.FollowerEntity

class FollowerMapper: BaseMapper<ResponseFollowersDto, FollowerEntity> {
    override fun map(from: ResponseFollowersDto): FollowerEntity =
        FollowerEntity(from.id, from.avatar_url, from.html_url)
}