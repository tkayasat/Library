package com.example.library.library.cache

import com.example.library.library.cache.db.AppDatabase
import com.example.library.library.cache.db.model.RoomGithubRepo
import com.example.library.library.model.GithubRepoModel
import com.example.library.library.model.GithubRepoOwner
import com.example.library.library.model.GithubUserModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubRepoCache @Inject constructor(
    private val db: AppDatabase,
) {

    fun insertRepos(repos: List<GithubRepoModel>): Single<List<GithubRepoModel>> {
        val dbRepos = repos.map {
            RoomGithubRepo(it.id, it.name, it.owner.id, it.forksCount)
        }
        return db.repositoryDao.insert(dbRepos)
            .toSingle { repos }
    }

    fun getRepos(userModel: GithubUserModel): Single<List<GithubRepoModel>> {
        return db.repositoryDao.getByUserId(userModel.id)
            .map { list ->
                list.map { repo ->
                    GithubRepoModel(
                        repo.id,
                        repo.name,
                        GithubRepoOwner(repo.userId),
                        repo.forksCount
                    )
                }
            }
    }
}