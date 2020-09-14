package com.hing.publicrepositories.data

import com.hing.publicrepositories.data.remote.RepoRemoteDataSource
import com.hing.publicrepositories.entities.Repo
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Hung Luong on 9/9/2020.
 */
@Singleton
class RepoRepository @Inject constructor(
    private val remoteDataSource: RepoRemoteDataSource
) {
    fun getPublicRepoList(): Single<MutableList<Repo>> {
        return remoteDataSource.getPublicRepoList()
    }
}
