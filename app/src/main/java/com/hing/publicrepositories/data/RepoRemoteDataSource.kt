package com.hing.publicrepositories.data

import com.hing.publicrepositories.entities.Repo
import com.hing.publicrepositories.network.RepoService
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Hung Luong on 9/9/2020.
 */
class RepoRemoteDataSource @Inject constructor(
    private val repoService: RepoService
) {
    fun getPublicRepoList(): Single<MutableList<Repo>> {
        return repoService.getPublicRepoList()
    }
}
