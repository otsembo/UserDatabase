package com.otsembo.userdatabase.db

import androidx.room.* // ktlint-disable no-wildcard-imports
import com.otsembo.userdatabase.model.User

@Dao
interface UserDao {
    // CRUD (Create Read Update Delete)
    @Insert
    fun createUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE email_address = :email")
    fun getUserByEmail(email: String): List<User>
}
