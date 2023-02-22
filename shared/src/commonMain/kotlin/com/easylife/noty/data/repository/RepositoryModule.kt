package com.easylife.noty.data.repository

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 19.02.2023
 */
val repositoryModule = module {
    factoryOf(::NoteRepository)
}