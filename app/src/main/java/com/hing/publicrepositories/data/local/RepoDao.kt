package com.hing.publicrepositories.data.local

import androidx.room.*
import com.hing.publicrepositories.entities.Repo
import io.reactivex.Completable
import io.reactivex.Maybe

/**
 * Created by Hung Luong on 9/10/2020.
 */
@Dao
interface RepoDao {
    @Query("SELECT * FROM repo")
    fun getPublicRepoList(): Maybe<MutableList<Repo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepo(repo: Repo): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepoList(vararg repos: Repo)

    @Delete
    fun delete(repo: Repo)
}
