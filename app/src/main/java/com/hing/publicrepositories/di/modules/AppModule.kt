package com.hing.publicrepositories.di.modules

import android.content.Context
import com.hing.publicrepositories.RepoApplication
import com.hing.publicrepositories.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Hung Luong on 9/14/2020.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    @ApplicationContext
    fun applicationContext(repoApplication: RepoApplication): Context {
        return repoApplication
    }
}
