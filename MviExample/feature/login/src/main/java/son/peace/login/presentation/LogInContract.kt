package son.peace.login.presentation

import son.peace.core.*
import son.peace.common.domain.UserEntity

class LogInContract {
    sealed class LoginIntent: MviIntent {
        object LogIn: LoginIntent()
    }

    data class LoginState (
        override val isNetworkAvailable: Boolean = true,
        val onNetworking: Boolean = false,
        val user: UserEntity? = null,
        val error: Throwable? = null
    ): MviViewState

    sealed class LoginEffect: MviSideEffect{
        data class NavigateToMainView(val user: UserEntity): LoginEffect()
        object ShowErrorToast: LoginEffect()
    }
}