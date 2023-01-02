package com.example.firebasefirestorewithhilt.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.firebasefirestorewithhilt.data.Courses
import com.example.firebasefirestorewithhilt.ui.MainActivity
import com.example.firebasefirestorewithhilt.util.FireStoreCollection
import com.example.firebasefirestorewithhilt.util.UiState
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class MainRepoImpl @Inject constructor(private var dbFirestore: FirebaseFirestore) : MainRepo {

    override fun addCourse(course: Courses, result: (UiState<Pair<Courses, String>>) -> Unit) {
        val document = dbFirestore.collection(FireStoreCollection.COURSES).document()
        document.set(course)
            .addOnSuccessListener {
                result.invoke(
                    UiState.Success(Pair(course, "courses has been created success"))
                )
            }
            .addOnFailureListener {
                result.invoke(
                    UiState.Failure(
                        it.stackTraceToString()
                    )
                )
            }
    }

}