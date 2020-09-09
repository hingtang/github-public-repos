package com.hing.publicrepositories.components.repolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.hing.publicrepositories.R
import com.hing.publicrepositories.RepoApplication
import kotlinx.android.synthetic.main.activity_repoy_list.*
import javax.inject.Inject

class RepoListActivity : AppCompatActivity() {
    @Inject lateinit var viewModel: RepoListViewModel

    private lateinit var repoListAdapter: RepoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as RepoApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repoy_list)

        initRepoRecyclerView()
        observeViewModel()
        viewModel.getPublicRepoList()
    }

    private fun observeViewModel() {
        viewModel.repoList.observe(this, {
            repoListAdapter.updateRepoList(it)
        })
    }

    private fun initRepoRecyclerView() {
        repoListAdapter = RepoListAdapter()
        repoRecyclerView.apply {
            adapter = repoListAdapter
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    this@RepoListActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }
}
