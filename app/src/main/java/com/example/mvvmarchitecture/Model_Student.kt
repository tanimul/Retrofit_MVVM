package com.example.mvvmarchitecture

import com.google.gson.annotations.SerializedName

data class Model_Student(
    @SerializedName("name") var name: String,
    @SerializedName("universityid") var universityid: String,
    @SerializedName("coursecode") var coursecode: String

)
