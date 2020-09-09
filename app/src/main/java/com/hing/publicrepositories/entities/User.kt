package com.hing.publicrepositories.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by Hung Luong on 8/26/2020.
 */
data class User(
    @SerializedName("id")
    val userId: Long,
    @SerializedName("login")
    val loginName: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
)
