package com.otsembo.userdatabase

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.otsembo.userdatabase.db.AppDatabase
import com.otsembo.userdatabase.db.UserDao
import com.otsembo.userdatabase.model.User
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var userDao: UserDao
    private lateinit var db: AppDatabase
    private lateinit var context: Context

    @Before
    fun testSetup() {
        context = ApplicationProvider.getApplicationContext()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        userDao = db.userDao()
    }

    @After
    @Throws(IOException::class)
    fun testDestroy() {
        db.close()
    }

    @Test
    fun addDataTest() {
        val user1 = User(0, "test name", "", "")
        val user2 = User(0, "another", "", "")
        val user3 = User(0, "sample", "", "")
        val user4 = User(0, "random", "", "")

        userDao.insertUser(user1, user2, user3, user4)
        val userList = userDao.getAll()
        assertEquals(3, userList.size)
    }
}
