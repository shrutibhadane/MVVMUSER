package com.example.enfecdemo.viewModel.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.enfecdemo.api.RestEndPoints
import com.example.enfecdemo.api.RetroFitInstance
import com.example.enfecdemo.model.database.UsersRoomDB
import com.example.enfecdemo.model.database.daos.UsersDao
import com.example.enfecdemo.model.database.model.Users
import timber.log.Timber
/**
 * Repository class that handles data operations for Users.
 * This class interacts with the local Room database and makes network calls using Retrofit.
 *
 * @property application The application context used to initialize the UserRepository.
 */
class UserRepository private constructor(application: Application) {

    private val usersDAO: UsersDao = UsersRoomDB.getDatabase(application).getUserDao()
    private val userCalls = RetroFitInstance.getInstance().create(RestEndPoints::class.java)

    /**
     * An 'init' block in Kotlin is called immediately after an Object is created, and never again.
     * This block is used only for demoing the Singleton pattern. UserRepository is accessed
     * from many classes at different times. If you watch the Logcat messages while switching
     * between screens, and filter by this class name, you'll notice that this message only appears
     * once, implying that its constructor is only being called once.
     */
    init {
        Timber.d("${this.javaClass.name} init for the first time.")
    }

    /**
     * Inserts a user into the local Room database.
     *
     * @param user The user object to be inserted.
     */
    private suspend fun insertUser(user: Users) {
        usersDAO.insertUser(user)
    }

    /**
     * Retrieves a LiveData list of all users from the local Room database.
     * This method also triggers a network call to fetch updated user data.
     *
     * @return LiveData object containing a list of Users.
     */
    suspend fun getAllUsersLiveData(): LiveData<List<Users>> {
        return usersDAO.getAllUsersLiveData().also {
            getAllUsersFromRemote()
        }
    }

    /**
     * Fetches a list of users from the remote server using Retrofit.
     * If successful, the users are inserted into the local database.
     */
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
         *  This is where the UserRepository all callers will receive. Set it to null at first
         *  and make it private so it can't be directly accessed.
         */
        private var INSTANCE: UserRepository? = null

        /**
         * This method checks whether or not INSTANCE is null. If it's not null, it returns the
         * Singleton INSTANCE. If it is null, it creates a new Object, sets INSTANCE equal to that,
         * and returns INSTANCE. From here on out, this method will now return the same INSTANCE,
         * every time.
         *
         * @param application The application context used to initialize the UserRepository.
         * @return The singleton instance of UserRepository.
         */
        fun getInstance(application: Application): UserRepository = INSTANCE ?: kotlin.run {
            INSTANCE = UserRepository(application = application)
            INSTANCE!!
        }
    }
}