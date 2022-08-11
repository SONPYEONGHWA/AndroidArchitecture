package son.peace.core

interface NetworkStatusReceiver {
    fun checkNetworkStatus(callback: (Boolean) -> Unit)
}