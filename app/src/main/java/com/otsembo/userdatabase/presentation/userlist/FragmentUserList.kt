package com.otsembo.userdatabase.presentation.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.otsembo.userdatabase.databinding.FragmentUserListBinding
import com.otsembo.userdatabase.presentation.UserAdapter

class FragmentUserList : Fragment() {

    private lateinit var binding: FragmentUserListBinding
    private val userListVM : UserListVM by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        val adapter = UserAdapter()
        binding.userList.adapter = adapter
        return binding.root
    }

}
