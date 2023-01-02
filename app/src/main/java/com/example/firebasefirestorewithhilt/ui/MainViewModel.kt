package com.example.firebasefirestorewithhilt.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebasefirestorewithhilt.data.Courses
import com.example.firebasefirestorewithhilt.repository.MainRepo
import com.example.firebasefirestorewithhilt.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: MainRepo) : ViewModel() {
    private val _add = MutableLiveData<UiState<Pair<Courses, String>>>()
    val add: LiveData<UiState<Pair<Courses, String>>>
        get() = _add


    fun savingCourses(courses: Courses){

        repo.addCourse(courses){
            _add.value = it
        }
    }

}