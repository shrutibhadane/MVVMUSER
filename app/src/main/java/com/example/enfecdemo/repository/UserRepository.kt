package com.example.enfecdemo.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.enfecdemo.api.RestEndPoints
import com.example.enfecdemo.api.RetrofitInstance
import com.example.enfecdemo.database.UsersRoomDB
import com.example.enfecdemo.database.dao.UsersDao
import com.example.enfecdemo.database.model.Users
import timber.log.Timber

class UserRepository private constructor(application: Application) {

    private val usersDAO: UsersDao = UsersRoomDB.getDatabase(application).getUserDao()
    private val userCalls = RetrofitInstance.getInstance().create(RestEndPoints::class.java)

    /**
     * An 'init' block in Kotlin is called immediately after an Object is created, and never again.
     * This block is used only for demoing the Singleton pattern. EmployeeRepository is accessed
     * from many classes at different times. If you watch the Logcot messages while switching
     * between screens, and filter by this class name, you'll notice that this message only appears
     * once, implying that its constructor is only being called once.
     */
    init {
        Timber.d("${this.javaClass.name} init for the first time.")
    }

    private suspend fun insertUser(user: Users) {
        usersDAO.insertUser(user)
    }

    suspend fun getAllUsersLiveData(): LiveData<List<Users>> {
        return usersDAO.getAllUsersLiveData().also {
            getAllUsersFromRemote()
        }
    }

    private suspend fun getAllUsersFromRemote() {
        try {
            val userList = userCalls.getUsersList()
            userList.forEach {
                insertUser(it)
            }
        } catch (exception: Throwable) {
            Timber.e(exception)
        }
    }


    // Singleton Pattern for Repository.
    companion object {
        /**
         *  This is where the EmployeeRepository all callers will receive. Set it to null at first
         *  and make it private so it can't be directly accessed.
         */
        private var INSTANCE: UserRepository? = null

        /**
         * This method checks whether or not INSTANCE is null. If it's not null, it returns the
         * Singleton INSTANCE. If it is null, it creates a new Object, sets INSTANCE equal to that,
         * and returns INSTANCE. From here on out, this method will now return the same INSTANCE,
         * every time.
         */
        fun getInstance(application: Application): UserRepository = INSTANCE ?: kotlin.run {
            INSTANCE = UserRepository(application = application)
            INSTANCE!!
        }
    }
}