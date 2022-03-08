package com.example.mvvmarchitecture

import androidx.lifecycle.LiveData
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiInterface {

    @GET("retrive.php")
    fun getList(): Observable<Model_Response>

    //Main Thread testing
    @POST("insert.php")
    fun createStudent(@Body modelStudent: Model_Student): Observable<String>


    @GET("retrive.php")
    suspend fun getListByCoroutine(): Response<Model_Response>

}