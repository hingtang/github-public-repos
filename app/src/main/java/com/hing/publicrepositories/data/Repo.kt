package com.hing.publicrepositories.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Hung Luong on 8/26/2020.
 */
data class Repo(
    val id: Long,
    @SerializedName("name")
    val repoName: String,
    @SerializedName("full_name")
    val repoFullName: String,
    val owner: User,
    val description: String
)
