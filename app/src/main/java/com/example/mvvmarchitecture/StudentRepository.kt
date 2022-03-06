package com.example.mvvmarchitecture

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlin.math.log

class StudentRepository(private val apiClient: ApiClient) {
    val TAG = "StudentRepository"
    val apiInterface: ApiInterface = apiClient.getClient()
    val result = MutableLiveData<Model_Response>()
    fun studentList(): LiveData<Model_Response> {

        apiInterface.getList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                Consumer<Model_Response> { modelrespose ->
                    Log.d(TAG, "accept: ")
                    if (modelrespose != null) {
                        result.postValue(modelrespose)
                        Log.d(TAG, "studentList: Response ->> "+modelrespose.data?.size)
                    }
                },
                Consumer<Throwable?> { Log.d(TAG, "accept: Throw") })
        Log.d(TAG, "studentList: Response ->> Returning Null")
        return result
    }

}