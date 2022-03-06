package com.example.mvvmarchitecture

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmarchitecture.databinding.ActivityShowlistBinding

class ShowlistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowlistBinding
    lateinit var studentViewModel: StudentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(StudentViewModel::class.java)

        Log.d("ShowlistActivity", "onCreate: ")
//        studentViewModel.getStudentList()?.observe(this, Observer { list ->
//            list?.let {
//                Log.d("ShowlistActivity", "onCreate: " + it)
//
//            }
//        })


//        });
        studentViewModel.allWorkes.observe(
            this
        ) { modelrespose ->
            Log.d(
                "ShowlistActivity", "onChanged: " + modelrespose.data
            )
        }
    }
}