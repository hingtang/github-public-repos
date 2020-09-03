package com.hing.publicrepositories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hing.publicrepositories.data.Repo
import com.hing.publicrepositories.network.RepoService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Hung Luong on 8/26/2020.
 */
class RepoListViewModel(
    private val repoService: RepoService
) : ViewModel() {
    val repoList = MutableLiveData<MutableList<Repo>>()

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun getPublicRepoList() {
        val disposable = repoService.getPublicRepoList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                repoList.value = it
            }, {

            })
        compositeDisposable.add(disposable)
    }
}
