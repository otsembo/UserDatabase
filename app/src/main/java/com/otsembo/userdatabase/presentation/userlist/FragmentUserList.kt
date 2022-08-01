package com.otsembo.userdatabase.presentation.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.otsembo.userdatabase.databinding.FragmentUserListBinding
import com.otsembo.userdatabase.db.AppDatabase
import com.otsembo.userdatabase.db.UserDao
import com.otsembo.userdatabase.model.User
import com.otsembo.userdatabase.presentation.UserListAdapter

class FragmentUserList : Fragment() {

    private lateinit var binding: FragmentUserListBinding
    private lateinit var userListVM: UserListVM
    private lateinit var db: AppDatabase
    private lateinit var userDao: UserDao

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        // val adapter = UserAdapter(emptyList())
//        val adapter = UserListAdapter()
//        binding.userList.adapter = adapter
//
//        // CHANGE ITEMS IN ADAPTER
//        val userList = ArrayList<User>()
//        userList.add(User(0, "test name", "", ""))
//        userList.add(User(0, "another", "", ""))
//        userList.add(User(0, "sample", "", ""))
//        userList.add(User(0, "random", "", ""))
//        adapter.submitList(userList)
        db = AppDatabase.getDb(requireContext())
        userDao = db.userDao()
        userListVM = UserListVM(userDao)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = userListVM
    }
}
