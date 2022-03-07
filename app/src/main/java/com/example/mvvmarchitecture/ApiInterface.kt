package com.example.mvvmarchitecture

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiInterface {

    @GET("retrive.php")
    fun getList(): Observable<Model_Response>


    //Main Thread testing
    @POST("insert.php")
    fun createStudent(@Body modelStudent: Model_Student): Observable<String>

    // suspend fun
}