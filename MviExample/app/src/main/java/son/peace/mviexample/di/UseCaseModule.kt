package son.peace.mviexample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import son.peace.login.domain.repository.LoginRepository
import son.peace.login.domain.usecase.LoginUseCase
import son.peace.login.domain.usecase.LoginUseCaseImpl
import son.peace.mypage.domain.FetchFollowersUseCase
import son.peace.mypage.domain.FetchFollowersUseCaseImpl
import son.peace.mypage.domain.FollowerListRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideLoginUseCase(loginRepository: LoginRepository): LoginUseCase =
        LoginUseCaseImpl(loginRepository)

    @Provides
    @Singleton
    fun provideFetchFollowersUseCase(followerListRepository: FollowerListRepository): FetchFollowersUseCase =
        FetchFollowersUseCaseImpl(followerListRepository)
}