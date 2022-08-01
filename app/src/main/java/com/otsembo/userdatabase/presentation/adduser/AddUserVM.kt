package com.otsembo.userdatabase.presentation.adduser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otsembo.userdatabase.db.AppDatabase
import com.otsembo.userdatabase.model.User
import kotlinx.coroutines.launch

class AddUserVM(private val db: AppDatabase) : ViewModel() {

    private val userDao = db.userDao()

    val email: MutableLiveData<String> = MutableLiveData("")
    val phone: MutableLiveData<String> = MutableLiveData("")
    val name: MutableLiveData<String> = MutableLiveData("")

    fun addUser() {
        val user = User(id = 0, name = name.value!!, email = email.value!!, phone = phone.value!!)
        viewModelScope.launch { userDao.createUser(user) }
    }

    fun delete(user: User) {
        viewModelScope.launch {
            userDao.deleteUser(user)
        }
    }

    fun update(user: User) {
        viewModelScope.launch {
            userDao.updateUser(user)
        }
    }
}
