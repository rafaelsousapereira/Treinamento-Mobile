package com.treinamentomobile.api2.data.repository

import com.treinamentomobile.api2.data.model.Student
import com.treinamentomobile.api2.data.remote.RetrofitClient

class StudentRepositorty {

    suspend fun getStudent(): List<Student> {
        return RetrofitClient.api.getStudents()
    }


    suspend fun createStudent(student: Student): Student {
        return RetrofitClient.api.createStudent(student)
    }

    suspend fun removeStudent(id: Int?) {
        return RetrofitClient.api.removeStudent(id)
    }
}