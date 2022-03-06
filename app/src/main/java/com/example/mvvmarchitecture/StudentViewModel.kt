package com.example.mvvmarchitecture


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class StudentViewModel : ViewModel() {
    val repository: StudentRepository
    val allWorkes: LiveData<Model_Response>

    init {
        repository= StudentRepository(apiClient = ApiClient())
        allWorkes = repository.studentList()
    }

}