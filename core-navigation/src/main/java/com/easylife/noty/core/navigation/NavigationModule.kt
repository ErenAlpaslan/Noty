package com.easylife.noty.core.navigation

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by erenalpaslan on 4.01.2023
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Binds
    @Singleton
    abstract fun provideDiaryComposeNavigator(
        notyComposeNavigator: NotyComposeNavigator
    ): NotyNavigator

}