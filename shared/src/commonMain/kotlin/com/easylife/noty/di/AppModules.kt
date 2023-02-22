package com.easylife.noty.di

import com.easylife.noty.data.database.realmModule
import com.easylife.noty.domain.useCaseModule
import com.easylife.noty.utils.dispatchers.dispatcherModule

/**
 * Created by erenalpaslan on 19.02.2023
 */
fun appModules() = listOf(dispatcherModule, realmModule,  useCaseModule)