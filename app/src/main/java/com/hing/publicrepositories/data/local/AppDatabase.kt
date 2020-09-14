package com.hing.publicrepositories.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hing.publicrepositories.entities.Repo
import com.hing.publicrepositories.entities.User

/**
 * Created by Hung Luong on 9/10/2020.
 */
@Database(entities = [Repo::class, User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao

    companion object{
        const val DATABASE_NAME = "Repo Database"
    }
}
