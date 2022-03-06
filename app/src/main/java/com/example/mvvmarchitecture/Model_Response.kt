package com.example.mvvmarchitecture

import com.google.gson.annotations.SerializedName

data class Model_Response(
    @SerializedName("data") var data: List<Model_Student> ?= null,
    @SerializedName("success") var success: String ?= null
)
