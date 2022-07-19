package com.otsembo.userdatabase.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.otsembo.userdatabase.databinding.UserItemBinding
import com.otsembo.userdatabase.model.User


class UserAdapter(private val userList : List<User>) : RecyclerView.Adapter<UserAdapter.UserHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding : UserItemBinding = UserItemBinding.inflate(inflater, parent, false)
        return UserHolder(binding)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val currentUser = userList[position]
        holder.bindData(currentUser)
    }

    override fun getItemCount(): Int = userList.size

    class UserHolder(private val binding : UserItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(user: User){
            binding.txtName.text = user.name
            binding.txtEmail.text = user.email
            binding.txtPhone.text = user.phone
            binding.executePendingBindings()
        }
    }

}