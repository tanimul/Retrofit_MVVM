package com.example.mvvmarchitecture


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class StudentViewModel : ViewModel() {
    val repository: StudentRepository
    val allWorkes: LiveData<Model_Response>

    init {
        repository = StudentRepository()
        allWorkes = repository.studentList()
    }

    fun createNewStudent(student: Model_Student): LiveData<String> {
        return repository.createStudent(student)
    }

}