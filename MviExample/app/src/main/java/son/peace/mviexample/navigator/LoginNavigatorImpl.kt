package son.peace.mviexample.navigator

import android.app.Activity
import android.content.Intent
import com.google.gson.Gson
import son.peace.common.domain.UserEntity
import son.peace.login.presentation.LoginNavigator
import son.peace.mviexample.MainActivity
import son.peace.mviexample.MainActivity.Companion.USER_ENTITY
import javax.inject.Inject

class LoginNavigatorImpl @Inject constructor(private val activity: Activity): LoginNavigator {
    override fun navigateToMain(user: UserEntity) {
        Intent(activity, MainActivity::class.java).also {
            it.putExtra(USER_ENTITY, Gson().toJson(user))
            activity.startActivity(it)
        }
    }
}