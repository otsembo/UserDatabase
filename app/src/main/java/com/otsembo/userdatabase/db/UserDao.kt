package com.otsembo.userdatabase.db

import androidx.lifecycle.LiveData
import androidx.room.* // ktlint-disable no-wildcard-imports
import com.otsembo.userdatabase.model.User

@Dao
interface UserDao {
    // CRUD (Create Read Update Delete)
    @Insert
    suspend fun createUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE email_address = :email")
    suspend fun getUserByEmail(email: String): List<User>
}
