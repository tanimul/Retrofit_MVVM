package com.example.mvvmarchitecture

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmarchitecture.databinding.ActivityAddUpdateBinding

class Add_Update_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityAddUpdateBinding
    lateinit var studentViewModel: StudentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[StudentViewModel::class.java]
        binding.btRatrofitSave.setOnClickListener {
            DataSend()
        }

    }

    fun DataSend() {
        val fullName: String =
            binding.etRatrofitFullName.text.toString()
        val universityId: String =
            binding.etRatrofitUniversityId.text.toString()
        val courseCode: String =
            binding.etRatrofitCourseCode.text.toString()

        if (fullName.isEmpty() || universityId.isEmpty() || courseCode.isEmpty()) {
            Toast.makeText(this, "Please fill all field", Toast.LENGTH_SHORT).show()
            return
        } else {
            val modelStudent = Model_Student(fullName, universityId, courseCode)
            studentViewModel.createNewStudent(modelStudent)
                .observe(this, Observer<String>() {
                    if (it != null && it.equals("Data Inserted")) {
                        Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show()
                    }

                })
        }
    }
}