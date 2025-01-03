package com.android.study

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    private val _numberFlow = flow {
        emit(_numberState.value + 1)
    }

    private val _numberState = MutableStateFlow(0)
    val numberState get() = _numberState.asStateFlow()

    init {
        viewModelScope.launch {
            while (true) {
                delay(1000)
                _numberFlow.collect { value ->
                    _numberState.value = value
                }
            }
        }
    }
}