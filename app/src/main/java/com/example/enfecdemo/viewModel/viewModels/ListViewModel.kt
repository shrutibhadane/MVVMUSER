package com.example.enfecdemo.viewModel.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.enfecdemo.model.database.model.Users
import com.example.enfecdemo.viewModel.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
/**
 * ViewModel for managing the list of Users data.
 *
 * This ViewModel class acts as a coordinator between the local Room database and the remote API
 * for Users data. It provides LiveData for observing a list of Users.
 *
 * @param application The application context used to initialize the ViewModel.
 */
class ListViewModel (application: Application) : AndroidViewModel(application) {

    // Repository instance for handling User data operations
    private val userRepository = UserRepository.getInstance(application)

    // LiveData representing a list of Users fetched from the database
    val usersListLiveData: LiveData<List<Users>> = liveData(Dispatchers.IO) {
        emitSource(userRepository.getAllUsersLiveData())
    }
}