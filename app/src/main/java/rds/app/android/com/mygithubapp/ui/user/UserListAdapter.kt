package rds.app.android.com.mygithubapp.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import rds.app.android.com.mygithubapp.databinding.RvItemBinding
import rds.app.android.com.mygithubapp.model.GithubUser

class UserListAdapter : ListAdapter<GithubUser, UserListAdapter.UserHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val user = getItem(position)

        holder.apply {
            bind(user)
        }
    }


    companion object DiffCallback : DiffUtil.ItemCallback<GithubUser>() {
        override fun areItemsTheSame(oldItem: GithubUser, newItem: GithubUser): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GithubUser, newItem: GithubUser): Boolean {
            return oldItem == newItem
        }
    }


    class UserHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: GithubUser) {
            binding.user = user
            binding.executePendingBindings()
        }

    }


}