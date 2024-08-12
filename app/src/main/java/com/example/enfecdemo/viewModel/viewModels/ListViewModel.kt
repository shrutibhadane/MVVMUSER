package com.example.enfecdemo.viewModel.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.enfecdemo.model.database.model.Users
import com.example.enfecdemo.viewModel.repositories.UserRepository
import kotlinx.coroutines.Dispatchers

class ListViewModel (application: Application) : AndroidViewModel(application) {

    // coordinates between the local and remote databases
    private val userRepository = UserRepository.getInstance(application)

    // This LiveData is created using a ktx library shortcut
    val usersListLiveData: LiveData<List<Users>> = liveData(Dispatchers.IO) {
        emitSource(userRepository.getAllUsersLiveData())
    }
}