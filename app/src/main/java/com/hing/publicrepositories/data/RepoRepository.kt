package com.hing.publicrepositories.data

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Hung Luong on 9/9/2020.
 */
@Singleton
class RepoRepository @Inject constructor(
    private val remoteDataSource: RepoRemoteDataSource
) {
    fun getPublicRepoList() {
    }
}
