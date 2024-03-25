package com.example.splashscreen.di

import com.example.splashscreen.interactor.SplashScreenInteractor
import com.example.splashscreen.interactor.SplashScreenInteractorImpl
import com.example.splashscreen.navigator.LinkNavigator
import com.example.splashscreen.navigator.LinkNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface NavigationModule {
    @Binds
    fun bindLinkNavigator(bind: LinkNavigatorImpl): LinkNavigator
}
