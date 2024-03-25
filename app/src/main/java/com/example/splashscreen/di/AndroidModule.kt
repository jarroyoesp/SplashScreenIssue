package com.example.splashscreen.di

import com.example.splashscreen.interactor.SplashScreenInteractor
import com.example.splashscreen.interactor.SplashScreenInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
internal interface AndroidActivityRetainedModule {
    @Binds
    fun bindSplashScreenInteractor(bind: SplashScreenInteractorImpl): SplashScreenInteractor
}