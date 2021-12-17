package com.example.library.newproject_cicerone.db.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.library.newproject_cicerone.db.db.dao.RepoDao
import com.example.library.newproject_cicerone.db.db.dao.UserDao
import com.example.library.newproject_cicerone.db.db.model.RoomGithubRepo
import com.example.library.newproject_cicerone.db.db.model.RoomGithubUser
import com.example.library.newproject_cicerone.ui.ui.App

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