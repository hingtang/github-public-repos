package com.hing.publicrepositories.components.repolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hing.publicrepositories.R
import com.hing.publicrepositories.entities.Repo
import com.hing.publicrepositories.extensions.loadCircleImageURL

/**
 * Created by Hung Luong on 8/27/2020.
 */
class RepoListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var repoList = mutableListOf<Repo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RepoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RepoViewHolder).bind(repoList[position])
    }

    override fun getItemCount() = repoList.size

    fun updateRepoList(repoList: MutableList<Repo>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }

    fun addRepoList(repoList: MutableList<Repo>) {
        val startPos = this.repoList.size
        this.repoList.addAll(repoList)
        notifyItemRangeInserted(startPos, repoList.size)
    }

    class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvRepoName = lazy<TextView> { itemView.findViewById(R.id.tvRepoName) }
        private val tvDescription = lazy<TextView> { itemView.findViewById(R.id.tvDescription) }
        private val tvOwnerName = lazy<TextView> { itemView.findViewById(R.id.tvOwnerName) }
        private val imgOwnerAvatar = lazy<ImageView> { itemView.findViewById(R.id.imgOwnerAvatar) }

        fun bind(repo: Repo) {
            tvRepoName.value.text = repo.repoName
            tvDescription.value.text = repo.description
            tvOwnerName.value.text = repo.owner.loginName
            imgOwnerAvatar.value.loadCircleImageURL(
                repo.owner.avatarUrl,
                R.drawable.ic_baseline_account_circle
            )
        }
    }
}
