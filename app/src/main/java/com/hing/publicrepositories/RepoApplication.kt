package com.hing.publicrepositories

import android.app.Application
import com.hing.publicrepositories.di.DaggerApplicationComponent

/**
 * Created by Hung Luong on 9/9/2020.
 */
class RepoApplication : Application(){
    val appComponent = DaggerApplicationComponent.create()
}
