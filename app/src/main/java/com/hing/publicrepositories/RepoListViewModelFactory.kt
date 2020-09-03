package com.hing.publicrepositories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hing.publicrepositories.network.RepoService

/**
 * Created by Hung Luong on 9/3/2020.
 */
class RepoListViewModelFactory(private val repoService: RepoService) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(RepoService::class.java).newInstance(repoService)
    }
}
