package com.easylife.noty.feature.splash

import androidx.lifecycle.viewModelScope
import com.easylife.noty.core.designsystem.base.BaseViewModel
import com.easylife.noty.core.navigation.NotyNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by erenalpaslan on 19.12.2022
 */
@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navigator: NotyNavigator
) : BaseViewModel() {

    /*private val shouldShowThemeSelection: Flow<Boolean> = flow {
        emit(preferencesManager.getBoolean(PreferencesKeys.IS_FIRST_ENTER))
    }*/

    init {
        viewModelScope.launch {
            /*shouldShowThemeSelection.map {
                if (it)
                    SplashUiState.NewComer
                else
                    SplashUiState.OnBoardedUser
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = SplashUiState.Loading
            ).collect {
                when (it) {
                    SplashUiState.Loading -> {}
                    SplashUiState.NewComer -> navigator.navigate(DiaryRoutes.themeRoute)
                    SplashUiState.OnBoardedUser -> navigator.navigate(DiaryRoutes.diaryRoute) {
                        popUpTo(DiaryRoutes.splashRoute) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            }*/
        }
    }

}