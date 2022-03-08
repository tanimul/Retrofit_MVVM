package com.example.mvvmarchitecture


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class StudentViewModel : ViewModel() {
    val repository: StudentRepository
    val allWorkes: LiveData<Model_Response?>
    val allWorkesCoroutine = MutableLiveData<List<Model_Student>?>()

    init {
        repository = StudentRepository()
        allWorkes = repository.studentList()
    }

    fun createNewStudent(student: Model_Student): LiveData<String?> {
        return repository.createStudent(student)
    }

    fun getListCoroutine() {
        viewModelScope.launch(Dispatchers.IO) {

            if (repository.getListCoroutine().body()?.data != null) {
                Log.d("fabniwfire", "getListCoroutine: " + repository.getListCoroutine().body())
                allWorkesCoroutine.postValue(repository.getListCoroutine().body()?.data)
            }


        }
    }

}