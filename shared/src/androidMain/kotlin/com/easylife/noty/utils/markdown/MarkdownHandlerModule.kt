package com.easylife.noty.utils.markdown

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 12.03.2023
 */
val markdownHandlerModule = module {
    factoryOf(::MarkdownHandler)
}