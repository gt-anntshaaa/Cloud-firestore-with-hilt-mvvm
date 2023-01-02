package com.example.firebasefirestorewithhilt.di

import com.example.firebasefirestorewithhilt.repository.MainRepo
import com.example.firebasefirestorewithhilt.repository.MainRepoImpl
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun provideMainRepo(database: FirebaseFirestore) : MainRepo{
        return MainRepoImpl(database)
    }
}