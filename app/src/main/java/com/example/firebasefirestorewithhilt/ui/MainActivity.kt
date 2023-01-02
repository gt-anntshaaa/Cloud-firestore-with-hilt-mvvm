package com.example.firebasefirestorewithhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.firebasefirestorewithhilt.R
import com.example.firebasefirestorewithhilt.data.Courses
import com.example.firebasefirestorewithhilt.databinding.ActivityMainBinding
import com.example.firebasefirestorewithhilt.util.FireStoreCollection
import com.example.firebasefirestorewithhilt.util.UiState
import com.example.firebasefirestorewithhilt.util.toast
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.idBtnSubmitCourse.setOnClickListener {
            Log.d("MainActivity", "Button clicked")
            val name = binding.idEdtCourseName.text.toString()
            val description = binding.idEdtCourseDescription.text.toString()

            mainViewModel.savingCourses(Courses(name, description))

        }

        mainViewModel.add.observe(this){
            Log.d("MainActivity", "Viewmodel dipanggil")
            when(it){
                is UiState.Loading -> {}
                is UiState.Failure -> {
                    toast(it.error.toString())
                }
                is UiState.Success -> {
                    toast(it.data.second)
                    val courses = it.data.second
                }
            }
        }
    }
}