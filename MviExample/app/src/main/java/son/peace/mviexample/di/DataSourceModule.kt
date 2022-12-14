package son.peace.mviexample.di

import com.apollographql.apollo3.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import son.peace.friends.data.remote.source.FollowerListDataSource
import son.peace.friends.data.remote.source.FollowerListDataSourceImpl
import son.peace.login.data.remote.api.LoginApiService
import son.peace.login.data.remote.source.LoginDataSource
import son.peace.login.data.remote.source.LoginDataSourceImpl
import son.peace.mypage.data.remote.api.MyPageApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideLoginDataSource(apolloClient: ApolloClient): LoginDataSource =
        LoginDataSourceImpl(apolloClient)

    @Provides
    @Singleton
    fun provideFollowerListDataSource(myPageApiService: MyPageApiService): FollowerListDataSource =
        FollowerListDataSourceImpl(myPageApiService)
}