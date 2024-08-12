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

/**
 * Room Database class for managing the Users table.
 */
@Database(entities = [Users::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class UsersRoomDB : RoomDatabase() {

    /**
     * Abstract method to retrieve the UsersDao interface.
     */
    abstract fun getUserDao(): UsersDao

    companion object {
        private var INSTANCE: UsersRoomDB? = null

        /**
         * Get an instance of the UsersRoomDB database.
         *
         * @param context The application context.
         * @return The UsersRoomDB database instance.
         */
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