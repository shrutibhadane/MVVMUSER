package com.example.enfecdemo.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.enfecdemo.model.database.converters.Converters
import com.example.enfecdemo.model.database.daos.UsersDao
import com.example.enfecdemo.model.database.model.Users
import com.example.enfecdemo.utils.ROOM_DB_NAME

@Database(entities = [Users::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class UsersRoomDB : RoomDatabase() {

    abstract fun getUserDao(): UsersDao

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