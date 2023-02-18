package com.easylife.feature.premium

import com.easylife.noty.core.designsystem.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by erenalpaslan on 11.02.2023
 */
@HiltViewModel
class PremiumViewModel @Inject constructor() : BaseViewModel() {


    val list = listOf(
        PremiumItem(
            "Week",
            "0.99$",
            null
        ),
        PremiumItem(
            "Month",
            "1.99$",
            "SAVE 22%"
        ),
        PremiumItem(
            "Year",
            "22,50$",
            "SAVE 44%"
        )
    )

}