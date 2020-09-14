package com.hing.publicrepositories.components.repolist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hing.publicrepositories.data.RepoRepository
import com.hing.publicrepositories.entities.Repo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Hung Luong on 8/26/2020.
 */
class RepoListViewModel @Inject constructor(
    private val repoRepository: RepoRepository
) : ViewModel() {
    val repoList = MutableLiveData<MutableList<Repo>>()

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun getPublicRepoList() {
        val disposable = repoRepository.getPublicRepoList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                repoList.value = it

            }, {

            })
        compositeDisposable.add(disposable)
    }
}
