package com.example.library.library.cache.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.library.library.cache.db.dao.RepoDao
import com.example.library.library.cache.db.dao.UserDao
import com.example.library.library.cache.db.model.RoomGithubRepo
import com.example.library.library.cache.db.model.RoomGithubUser
import com.example.library.library.ui.ui.App

@Database(
    entities = [
        RoomGithubUser::class,
        RoomGithubRepo::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val repositoryDao: RepoDao
    companion object {
        private const val DB_NAME = "database.db"
        val instance by lazy {
            Room.databaseBuilder(App.instance, AppDatabase::class.java, DB_NAME)
                .build()
        }
    }
}