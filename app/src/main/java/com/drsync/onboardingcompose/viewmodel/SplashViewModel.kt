package com.drsync.onboardingcompose.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drsync.onboardingcompose.data.DataStoreRepository
import com.drsync.onboardingcompose.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
): ViewModel(){

    private val _isLoading = mutableStateOf<Boolean>(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination = mutableStateOf<String>(Screen.Welcome.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { compleated ->
                if(compleated) {
                    _startDestination.value = Screen.Home.route
                }else {
                    _startDestination.value = Screen.Welcome.route
                }
                _isLoading.value = false
            }
        }
    }
}