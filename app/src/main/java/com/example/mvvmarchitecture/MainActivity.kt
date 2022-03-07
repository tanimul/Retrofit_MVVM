package com.example.mvvmarchitecture

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var studentViewModel: StudentViewModel
    private lateinit var students: ArrayList<Model_Student>
    lateinit var studentAdapter: StudentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        students = ArrayList()
        studentAdapter = StudentAdapter(students);
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = studentAdapter

        studentViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[StudentViewModel::class.java]

        showList()

        binding.ivAdd.setOnClickListener {
            startActivity(Intent(this, Add_Update_Activity::class.java))
        }
    }

    private fun showList() {
        studentViewModel.allWorkes.observe(
            this
        ) {
            Log.d(
                "ShowlistActivity", "Data Observed: "
            )
            it.data?.let { it1 -> students.addAll(it1) }
            studentAdapter.notifyDataSetChanged()
        }
    }
}