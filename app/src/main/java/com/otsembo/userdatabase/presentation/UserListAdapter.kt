package com.otsembo.userdatabase.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.otsembo.userdatabase.databinding.UserItemBinding
import com.otsembo.userdatabase.model.User

class UserListAdapter : ListAdapter<User, UserListAdapter.UserListViewHolder>(UserDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val user = currentList[position]
        holder.bindData(user)
    }

    override fun getItemCount(): Int = currentList.size

    class UserListViewHolder(private val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(user: User) {
            binding.user = user
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): UserListViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = UserItemBinding.inflate(inflater, parent, false)
                return UserListViewHolder(binding)
            }
        }
    }
}

class UserDiffUtil : DiffUtil.ItemCallback<User>() {
    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = (oldItem == newItem)

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = (oldItem.id == newItem.id)
}
