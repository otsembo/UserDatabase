package com.otsembo.userdatabase.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.otsembo.userdatabase.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var APP_DB: AppDatabase? = null

        fun getDb(context: Context): AppDatabase {
            return APP_DB ?: synchronized(this) {
                APP_DB ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "user_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { db -> APP_DB = db }
            }
        }
    }
}
