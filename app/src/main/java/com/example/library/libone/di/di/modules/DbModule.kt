package com.example.library.libone.di.di.modules

import android.content.Context
import androidx.room.Room
import com.example.library.libone.cache.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val DB_NAME = "database.db"

@Module
class DbModule {

    @Singleton
    @Provides
    fun db(context: Context): AppDatabase =
        Room
            .databaseBuilder(context, AppDatabase::class.java, DB_NAME)
            .build()

}