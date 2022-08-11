package son.peace.mypage.presentation

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import son.peace.common.presentation.viewmodel.MviViewModel
import son.peace.core.StringConverter
import son.peace.mypage.domain.FetchFollowersUseCase
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val fetchFollowersUseCase: FetchFollowersUseCase,
    private val stringConverter: StringConverter
): MviViewModel<MyPageContract.MyPageIntent, MyPageContract.MyPageState, MyPageContract.MyPageEffect>() {
    override fun setInitialState(): MyPageContract.MyPageState = MyPageContract.MyPageState()
    override fun handleEvents(mviIntent: MyPageContract.MyPageIntent) {
        when(mviIntent) {
            is MyPageContract.MyPageIntent.LoadedMyInfo -> {
                setState { copy(myInfo = mviIntent.user) }
                fetchFollowerList(mviIntent.user.name)
            }
        }
    }

    private fun fetchFollowerList(userName: String) {
        viewModelScope.launch {
            fetchFollowersUseCase(stringConverter.removeSpaces(userName))
                .catch {
                    it.printStackTrace()
                    setState { copy(error = it) }
                }
                .collect {
                    setState { copy(followerList = it) }
                }
        }
    }
}