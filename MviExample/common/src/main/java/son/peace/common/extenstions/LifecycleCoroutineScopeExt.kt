package son.peace.common.extenstions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

inline fun <reified T, R> R.collectFlow(
    flow: Flow<T>,
    state: Lifecycle.State,
    crossinline block: suspend (T) -> Unit
) {
    when(this) {
        is AppCompatActivity -> {
            lifecycleScope.launch {
                flow.flowWithLifecycle(lifecycle, state).collect { block(it) }
            }
        }
        is Fragment -> {
            viewLifecycleOwner.lifecycleScope.launch {
                flow.flowWithLifecycle(viewLifecycleOwner.lifecycle, state).collect { block(it) }
            }
        }
    }
}

inline fun <reified T, reified R> R.collectWhenStarted(flow: Flow<T>, crossinline block:  suspend (T) -> Unit) =
    collectFlow(flow, Lifecycle.State.STARTED, block)