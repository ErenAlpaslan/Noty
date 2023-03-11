package com.easylife.noty.domain

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 19.02.2023
 */
val useCaseModule = module {
    factoryOf(::AddNoteUseCase)
    factoryOf(::GetNotesUseCase)
    factoryOf(::DeleteNoteUseCase)
    factoryOf(::GetNoteUseCase)
}