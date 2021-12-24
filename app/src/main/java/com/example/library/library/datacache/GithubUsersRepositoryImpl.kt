package com.example.library.library.datacache

import com.example.library.library.cache.GithubUserCache
import com.example.library.library.model.GithubUserModel
import com.example.library.library.domain.GithubUsersRepository
import com.example.library.library.remote.RetrofitService
import com.example.library.library.remote.connectivity.NetworkStatus
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