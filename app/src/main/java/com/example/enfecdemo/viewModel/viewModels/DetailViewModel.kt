package com.example.enfecdemo.viewModel.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.example.enfecdemo.model.models.Employee
import com.example.enfecdemo.viewModel.repositories.EmployeeRepository

class DetailViewModel(application: Application) : AndroidViewModel(application) {

    // coordinates between the local and remote databases
    private val employeeRepository = EmployeeRepository.getInstance(application)

    // This LiveData is created using a ktx library shortcut
    fun employeeLiveData(id: Int): LiveData<Employee?> = liveData(Dispatchers.IO) {
        emitSource(employeeRepository.getEmployeeByIdLiveData(id))
    }
}
