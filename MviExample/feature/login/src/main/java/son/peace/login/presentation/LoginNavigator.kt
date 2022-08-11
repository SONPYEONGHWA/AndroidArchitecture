package son.peace.login.presentation

import son.peace.common.domain.UserEntity

interface LoginNavigator {
    fun navigateToMain(user: UserEntity)
}