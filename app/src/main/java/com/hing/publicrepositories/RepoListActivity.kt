package com.hing.publicrepositories

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.hing.publicrepositories.network.RepoService
import kotlinx.android.synthetic.main.activity_repoy_list.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RepoListActivity : AppCompatActivity() {
    private lateinit var viewModel: RepoListViewModel
    private lateinit var repoListAdapter: RepoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repoy_list)
        initRepoRecyclerView()

        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .header("Accept", "application/vnd.github.v3+json")
                    .build()
                chain.proceed(request)
            }.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        val repoService = Retrofit.Builder().baseUrl("https://api.github.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
            .create(RepoService::class.java)
        val factory = RepoListViewModelFactory(repoService)
        viewModel = ViewModelProvider(this, factory).get(RepoListViewModel::class.java)
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
