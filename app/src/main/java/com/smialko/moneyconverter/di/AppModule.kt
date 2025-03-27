package com.smialko.moneyconverter.di

import android.app.Application
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDefaultSharedPre(
        application: Application
    ): SharedPreferences {
        return application.getSharedPreferences("default", Application.MODE_PRIVATE)
    }

}