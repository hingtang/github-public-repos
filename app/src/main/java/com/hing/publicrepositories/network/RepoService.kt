package com.hing.publicrepositories.network

import com.hing.publicrepositories.entities.Repo
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Hung Luong on 9/1/2020.
 */
interface RepoService {
    @GET("/repositories")
    fun getPublicRepoList(): Single<MutableList<Repo>>
}
