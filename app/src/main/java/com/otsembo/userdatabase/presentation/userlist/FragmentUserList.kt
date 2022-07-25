package com.otsembo.userdatabase.presentation.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.otsembo.userdatabase.databinding.FragmentUserListBinding
import com.otsembo.userdatabase.model.User
import com.otsembo.userdatabase.presentation.UserAdapter
import com.otsembo.userdatabase.presentation.UserListAdapter

class FragmentUserList : Fragment() {

    private lateinit var binding: FragmentUserListBinding
    private val userListVM: UserListVM by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        // val adapter = UserAdapter(emptyList())
        val adapter = UserListAdapter()
        binding.userList.adapter = adapter

        // CHANGE ITEMS IN ADAPTER
        val userList = ArrayList<User>()
        userList.add(User(0,"test name","",""))
        userList.add(User(0,"another","",""))
        userList.add(User(0,"sample","",""))
        userList.add(User(0,"random","",""))
        adapter.submitList(userList)

        return binding.root
    }
}
