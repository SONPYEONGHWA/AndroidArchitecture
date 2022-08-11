package son.peace.mviexample.di

import android.content.Context
import android.net.ConnectivityManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import son.peace.core.NetworkStatusReceiver
import son.peace.core.StringConverter
import son.peace.mviexample.NetworkStatusReceiverImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager =
        context.getSystemService(ConnectivityManager::class.java)

    @Provides
    @Singleton
    fun provideNetworkStatusReceiver(connectivityManager: ConnectivityManager): NetworkStatusReceiver =
        NetworkStatusReceiverImpl(connectivityManager)

    @Provides
    @Singleton
    fun provideStringConverter(): StringConverter = StringConverter()
}