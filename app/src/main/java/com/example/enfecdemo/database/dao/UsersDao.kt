package com.example.enfecdemo.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.enfecdemo.database.model.Users
@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: Users)

    @Query("SELECT * FROM users_table")
    fun getAllUsersLiveData(): LiveData<List<Users>>

}