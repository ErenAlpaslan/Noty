package com.easylife.noty.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.easylife.noty.core.designsystem.base.BaseScreen

/**
 * Created by erenalpaslan on 19.12.2022
 */
class SplashScreen : BaseScreen<SplashViewModel>() {
    @Composable
    override fun Screen() {
        Scaffold() {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = com.easylife.noty.core.designsystem.R.drawable.ic_user),
                    contentDescription = "",
                    modifier = Modifier.size(100.dp)
                )
            }
        }
    }
}