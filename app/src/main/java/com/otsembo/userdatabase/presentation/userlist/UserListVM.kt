package com.otsembo.userdatabase.presentation.userlist

import androidx.lifecycle.ViewModel
import com.otsembo.userdatabase.db.UserDao

class UserListVM(private val userDao: UserDao) : ViewModel() {

    val userList = userDao.getAllUsers()
}
