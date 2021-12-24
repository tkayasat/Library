package com.example.library.libone.datacache

import com.example.library.libone.cache.GithubUserCache
import com.example.library.libone.model.GithubUserModel
import com.example.library.libone.domain.GithubUsersRepository
import com.example.library.libone.remote.RetrofitService
import com.example.library.libone.remote.connectivity.NetworkStatus
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubUsersRepositoryImpl @Inject constructor(
    private val networkStatus: NetworkStatus,
    private val retrofitService: RetrofitService,
    private val usersCache: GithubUserCache,
) : GithubUsersRepository {
    override fun getUsers(): Single<List<GithubUserModel>> {
        return if (networkStatus.isOnline()) {
            retrofitService.getUsers()
                .flatMap(usersCache::insert)
        } else {
            usersCache.getUsers()
        }
    }
}