package son.peace.login.presentation

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import son.peace.common.presentation.viewmodel.MviViewModel
import son.peace.core.NetworkStatusReceiver
import son.peace.login.domain.usecase.LoginUseCase
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val networkChecker: NetworkStatusReceiver
): MviViewModel<LogInContract.LoginIntent, LogInContract.LoginState, LogInContract.LoginEffect>() {
    val userName = MutableStateFlow<String>("")

    init {
        checkNetworkStatus()
    }

    override fun setInitialState(): LogInContract.LoginState {
        return LogInContract.LoginState()
    }

    override fun handleEvents(mviIntent: LogInContract.LoginIntent) {
        when(mviIntent) {
            is LogInContract.LoginIntent.LogIn -> { getUser() }
        }
    }

    private fun getUser() {
        viewModelScope.launch {
            setState { copy(onNetworking = true, user = null, error = null) }
            loginUseCase(userName.value).catch {
                it.printStackTrace()
                setState { copy(onNetworking = false, user = null, error = it) }
                setEffect { LogInContract.LoginEffect.ShowErrorToast }
            }.collect {
                setState { copy(onNetworking = false, user = it, error = null) }
                setEffect { LogInContract.LoginEffect.NavigateToMainView(it) }
            }
        }
    }

    private fun checkNetworkStatus() {
        networkChecker.checkNetworkStatus {
            setState { copy(isNetworkAvailable = it ) }
        }
    }
}