package son.peace.mviexample.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import son.peace.login.presentation.LoginNavigator
import son.peace.mviexample.navigator.LoginNavigatorImpl

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigatorModule {

    @Binds
    abstract fun provideLoginNavigator(loginNavigatorImpl: LoginNavigatorImpl): LoginNavigator
}