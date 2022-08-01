package com.otsembo.userdatabase.presentation

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.otsembo.userdatabase.model.User

@BindingAdapter("userList")
fun RecyclerView.setUpUserList(users: List<User>?) {
    users?.let { userList ->
        val adapter = UserAdapter(userList)
        this.adapter = adapter
    }
}
