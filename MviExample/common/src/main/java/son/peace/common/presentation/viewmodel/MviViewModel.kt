package son.peace.common.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import son.peace.core.MviIntent
import son.peace.core.MviSideEffect
import son.peace.core.MviViewState

abstract class MviViewModel<I: MviIntent, S: MviViewState, E: MviSideEffect>: ViewModel() {
    abstract fun setInitialState(): S
    abstract fun handleEvents(mviIntent: I)

    private val _uiState = MutableStateFlow(setInitialState())
    val uiState: StateFlow<S> = _uiState.asStateFlow()

    private val _intent: MutableSharedFlow<I> = MutableSharedFlow()

    private val _effect: Channel<E> = Channel()
    val effect = _effect.receiveAsFlow()

    init {
        subscribeToEvents()
    }

    fun emitIntent(mviIntent: I) {
        viewModelScope.launch { _intent.emit(mviIntent) }
    }

    protected fun setState(reducer: S.() -> S) {
        val newState = uiState.value.reducer()
        _uiState.value = newState
    }

    protected fun setEffect(builder: () -> E) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }

    private fun subscribeToEvents() {
        viewModelScope.launch {
            _intent.collect {
                handleEvents(it)
            }
        }
    }
}