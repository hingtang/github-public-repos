package com.hing.publicrepositories.di

import com.hing.publicrepositories.components.repolist.RepoListActivity
import com.hing.publicrepositories.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Hung Luong on 9/9/2020.
 */
@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(activity: RepoListActivity)
}
