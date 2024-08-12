package com.example.enfecdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.enfecdemo.database.dao.UsersDao
import com.example.enfecdemo.database.model.Users
import com.example.enfecdemo.utils.ROOM_DB_NAME

@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class UsersRoomDB : RoomDatabase() {

    abstract fun getUserDao(): UsersDao

    /**
     *  Creates a way to ensure that the database accessed in different locations is the same
     *  instance. Also known as a Singleton pattern. Further explained in the Employee Repository.
     */
    companion object {
        private var INSTANCE: UsersRoomDB? = null

        fun getDatabase(context: Context) = INSTANCE ?: kotlin.run {
            Room.databaseBuilder(
                context.applicationContext,
                UsersRoomDB::class.java,
                ROOM_DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}