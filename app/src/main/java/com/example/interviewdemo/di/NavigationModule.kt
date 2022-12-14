package com.example.interviewdemo.di

import com.example.interviewdemo.navigation.AppNavigator
import com.example.interviewdemo.navigation.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {

    @Binds
    abstract fun bindNavigator(navigator: AppNavigatorImpl): AppNavigator
}