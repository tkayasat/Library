package com.example.library.library.cache

import com.example.library.library.cache.db.AppDatabase
import com.example.library.library.cache.db.model.RoomGithubUser
import com.example.library.library.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

class GithubUserCache(
    private val db: AppDatabase,
) {

    fun insert(users: List<GithubUserModel>): Single<List<GithubUserModel>> {
        val roomUsers = users.map { user ->
            RoomGithubUser(user.id, user.login, user.avatarUrl, user.reposUrl)
        }
        return db.userDao.insert(roomUsers)
            .toSingle { users }
    }

    fun getUsers(): Single<List<GithubUserModel>> {
        return db.userDao.getAll().map { users ->
            users.map { roomModel ->
                GithubUserModel(
                    roomModel.id,
                    roomModel.login,
                    roomModel.avatarUrl,
                    roomModel.reposUrl
                )
            }
        }
    }
}