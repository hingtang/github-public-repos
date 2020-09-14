package com.hing.publicrepositories.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Hung Luong on 8/26/2020.
 */
@Entity
data class User(
    @PrimaryKey val userId: Long,
    @ColumnInfo(name = "login") val loginName: String,
    @ColumnInfo(name = "avatar_url") val avatarUrl: String
)
