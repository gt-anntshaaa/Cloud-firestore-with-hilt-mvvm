package com.example.firebasefirestorewithhilt.repository

import com.example.firebasefirestorewithhilt.data.Courses
import com.example.firebasefirestorewithhilt.util.UiState

interface MainRepo {
    fun addCourse(course: Courses, result: (UiState<Pair<Courses,String>>) -> Unit)
}