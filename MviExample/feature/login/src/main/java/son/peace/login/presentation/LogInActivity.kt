package son.peace.login.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import son.peace.common.R
import son.peace.common.extenstions.collectWhenStarted
import son.peace.common.extenstions.getDeviceHeight
import son.peace.common.extenstions.showToast
import son.peace.common.presentation.AlertMessageBuilder
import son.peace.login.databinding.ActivityLogInBinding
import javax.inject.Inject

@AndroidEntryPoint
class LogInActivity: AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    private val loginViewModel by viewModels<LogInViewModel>()
    @Inject lateinit var loginNavigator: LoginNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        binding.loginViewModel = loginViewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        login()
        render()
    }

    private fun login() {
        binding.buttonLogin.setOnClickListener {
            loginViewModel.emitIntent(LogInContract.LoginIntent.LogIn)
        }
    }

    private fun render() {
        val alertMessage = AlertMessageBuilder(binding.rootlayout)
            .setMessage("네트워크 연결 상태를 확인해주세요.")
            .build()

        collectWhenStarted(loginViewModel.effect) { effect ->
            when(effect) {
                is LogInContract.LoginEffect.NavigateToMainView -> {
                    loginNavigator.navigateToMain(effect.user)
                }
                is LogInContract.LoginEffect.ShowErrorToast -> {
                    showToast("존재하지 않는 유저입니다.")
                }
            }
        }

        collectWhenStarted(loginViewModel.uiState) { state ->
                alertMessage.setMessageVisibility(!state.isNetworkAvailable)
        }
    }
}