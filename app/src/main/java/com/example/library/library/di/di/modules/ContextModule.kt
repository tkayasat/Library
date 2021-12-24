package com.example.library.library.di.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(private val app: Application) {

    @Singleton
    @Provides
    fun app(): Context {
        return app
    }
}