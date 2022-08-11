package son.peace.mviexample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import son.peace.friends.data.remote.source.FollowerListDataSource
import son.peace.login.data.mapper.UserMapper
import son.peace.login.data.remote.repository.LoginRepositoryImpl
import son.peace.login.data.remote.source.LoginDataSource
import son.peace.login.domain.repository.LoginRepository
import son.peace.mypage.data.mapper.FollowerMapper
import son.peace.mypage.data.remote.repository.FollowerListRepositoryImpl
import son.peace.mypage.domain.FollowerListRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideLoginRepository(
        loginDataSource: LoginDataSource,
        userMapper: UserMapper
    ): LoginRepository =
        LoginRepositoryImpl(loginDataSource, userMapper)

    @Provides

    @Singleton
    fun provideFollowerListRepository(
        followerListDataSource: FollowerListDataSource,
        followerMapper: FollowerMapper
    ): FollowerListRepository =
        FollowerListRepositoryImpl(followerListDataSource, followerMapper)
}