package com.example.library.newproject_cicerone.di.di.modules

import android.content.Context
import androidx.room.Room
import com.example.library.newproject_cicerone.db.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val DB_NAME = "database.db"

@Module
class CacheModule {

    @Singleton
    @Provides
    fun db(context: Context): AppDatabase =
        Room
            .databaseBuilder(context, AppDatabase::class.java, DB_NAME)
            .build()
}