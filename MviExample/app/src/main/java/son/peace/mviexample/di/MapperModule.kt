package son.peace.mviexample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import son.peace.login.data.mapper.UserMapper
import son.peace.mypage.data.mapper.FollowerMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    @Provides
    @Singleton
    fun provideUserMapper(): UserMapper = UserMapper()

    @Provides
    @Singleton
    fun provideFollowerMapper(): FollowerMapper = FollowerMapper()
}