package com.easylife.noty.di

import com.easylife.noty.data.database.realmModule
import com.easylife.noty.data.repository.repositoryModule
import com.easylife.noty.domain.useCaseModule
import com.easylife.noty.utils.dispatchers.dispatcherModule
import com.easylife.noty.utils.markdown.markdownHandlerModule

/**
 * Created by erenalpaslan on 19.02.2023
 */
fun appModules() =
    listOf(dispatcherModule, realmModule, useCaseModule, repositoryModule, markdownHandlerModule)