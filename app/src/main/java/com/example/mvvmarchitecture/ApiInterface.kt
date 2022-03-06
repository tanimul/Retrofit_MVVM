package com.example.mvvmarchitecture

import io.reactivex.Observable
import retrofit2.http.GET


interface ApiInterface {

    @GET("retrive.php")
    fun getList(): Observable<Model_Response>
}