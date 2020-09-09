package com.hing.publicrepositories.di

import com.hing.publicrepositories.data.RepoRepository
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Hung Luong on 9/9/2020.
 */
@Singleton
@Component
interface ApplicationComponent {
    fun repository(): RepoRepository
}
