package com.hing.publicrepositories.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Hung Luong on 8/26/2020.
 */
@Entity
data class Repo(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name") val repoName: String,
    @ColumnInfo(name = "full_name") val repoFullName: String,
    @Embedded val owner: User,
    val description: String
)
