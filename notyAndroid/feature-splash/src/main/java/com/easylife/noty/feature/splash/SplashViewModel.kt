package com.easylife.noty.feature.splash

import androidx.lifecycle.viewModelScope
import com.easylife.noty.core.designsystem.base.BaseViewModel
import com.easylife.noty.core.navigation.NotyNavigator
import com.easylife.noty.core.navigation.screen.NotyRoutes
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * Created by erenalpaslan on 19.12.2022
 */
class SplashViewModel(
    private val navigator: NotyNavigator
) : BaseViewModel() {

    private val _uiState: MutableStateFlow<SplashUiState> = MutableStateFlow(SplashUiState.OnBoardedUser)
    val uiState: StateFlow<SplashUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = SplashUiState.Loading
            ).collect {
                delay(1_000)
                when (it) {
                    SplashUiState.Loading -> {}
                    SplashUiState.NewComer -> navigator.navigate(NotyRoutes.onboardingRoute)
                    SplashUiState.OnBoardedUser -> navigator.navigate(NotyRoutes.homeRoute) {
                        popUpTo(NotyRoutes.splashRoute) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            }
        }
    }

}