package com.example.mvvmarchitecture

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import kotlin.math.log

class StudentRepository() {
    private val TAG: String = "StudentRepository"
    private val apiInterface: ApiInterface = ApiClient.getClient()

    fun studentList(): LiveData<Model_Response?> {
        val result = MutableLiveData<Model_Response?>()
        apiInterface.getList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                Consumer<Model_Response> { modelrespose ->
                    Log.d(TAG, "accept: ")
                    if (modelrespose != null) {
                        result.postValue(modelrespose)
                        Log.d(TAG, "studentList: Response ->> " + modelrespose.data?.size)
                    } else {
                        result.postValue(null)
                    }
                },
                Consumer<Throwable?> {
                    result.postValue(null)
                    Log.d(TAG, "accept: Throw")
                })
        Log.d(TAG, "studentList: Response ->> Returning Null")
        return result
    }

    fun createStudent(modelStudent: Model_Student): LiveData<String?> {
        val result = MutableLiveData<String?>()
        apiInterface.createStudent(modelStudent).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                Consumer { respose ->
                    Log.d(TAG, "Accept: $respose")

                    if (respose != null) {
                        result.postValue(respose)
                    } else {
                        result.postValue(null)
                    }
                }, Consumer<Throwable> {
                    result.postValue(null)
                    Log.d(TAG, "accept: Throw")
                }
            )
        return result
    }

    suspend fun getListCoroutine(): Response<Model_Response> {
        Log.d(TAG, "getList_Coroutine: "+apiInterface.getListByCoroutine().body())
        return apiInterface.getListByCoroutine()
    }

}