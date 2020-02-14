package rds.app.android.com.mygithubapp.ui.repositories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import rds.app.android.com.mygithubapp.databinding.RvReposItemBinding
import rds.app.android.com.mygithubapp.model.GithubRepo

class RepoListAdapter : ListAdapter<GithubRepo, RepoListAdapter.RepoViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(
            RvReposItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = getItem(position)

        holder.apply {
            bind(repo)
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<GithubRepo>() {
        override fun areItemsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
            return oldItem == newItem
        }
    }

    class RepoViewHolder(private val binding: RvReposItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: GithubRepo) {
            binding.repo = repo
            binding.executePendingBindings()
        }

    }


}