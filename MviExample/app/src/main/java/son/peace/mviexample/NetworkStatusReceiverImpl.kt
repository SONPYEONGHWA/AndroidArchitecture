package son.peace.mviexample

import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Network
import son.peace.core.NetworkStatusReceiver
import javax.inject.Inject

class NetworkStatusReceiverImpl @Inject constructor(
    private val connectivityManager: ConnectivityManager
): NetworkStatusReceiver {
    override fun checkNetworkStatus(callback: (Boolean) -> Unit) {
        callback(connectivityManager.activeNetwork != null)
        connectivityManager.registerDefaultNetworkCallback(object: ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                callback(true)
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                callback(false)
            }

            override fun onUnavailable() {
                super.onUnavailable()
                callback(false)
            }

            override fun onLinkPropertiesChanged(network: Network, linkProperties: LinkProperties) {
                super.onLinkPropertiesChanged(network, linkProperties)
            }
        })
    }
}