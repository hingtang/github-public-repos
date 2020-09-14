package com.hing.publicrepositories.di.modules

import android.content.Context
import androidx.room.Room
import com.hing.publicrepositories.data.local.AppDatabase
import com.hing.publicrepositories.data.local.AppDatabase.Companion.DATABASE_NAME
import com.hing.publicrepositories.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Hung Luong on 9/10/2020.
 */
@Module
class StorageModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
    }
}
