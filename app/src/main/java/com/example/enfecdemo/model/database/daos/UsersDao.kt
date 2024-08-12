package com.example.enfecdemo.model.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.enfecdemo.model.database.model.Users
/**
 * Data Access Object (DAO) for interacting with the Users table in the database.
 */
@Dao
interface UsersDao {

    /**
     * Insert a new user into the users_table. If the user already exists, replace it.
     *
     * @param user The user to be inserted or replaced.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: Users)

    /**
     * Retrieve all users from the users_table as LiveData.
     *
     * @return A LiveData list of all users in the users_table.
     */
    @Query("SELECT * FROM users_table")
    fun getAllUsersLiveData(): LiveData<List<Users>>

}