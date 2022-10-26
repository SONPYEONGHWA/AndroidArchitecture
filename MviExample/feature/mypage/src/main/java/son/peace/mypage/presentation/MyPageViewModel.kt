package son.peace.mypage.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.ApolloClient
import com.test.graphql.RepositoryOwnerQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import son.peace.common.presentation.viewmodel.MviViewModel
import son.peace.core.StringConverter
import son.peace.mypage.domain.FetchFollowersUseCase
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val fetchFollowersUseCase: FetchFollowersUseCase,
    private val stringConverter: StringConverter,
    private val apolloClient: ApolloClient
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

    private fun fetchRepositoryList() {
        viewModelScope.launch {

        }
    }

    private fun getRepository() {
        viewModelScope.launch {
            val result = apolloClient.query(
                RepositoryOwnerQuery("SONPYEONGHW", "AndroidArchitecture")
            ).execute()
        }
    }
}