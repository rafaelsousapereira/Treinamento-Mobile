package com.treinamentomobile.api2.data.service

import com.treinamentomobile.api2.data.model.Student
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface StudentService {

    @GET("students")
    suspend fun getStudents(): List<Student>

    @GET("students/{id}")
    suspend fun getStudentById(@Path("id") id: Int): Student

    @POST("students")
    suspend fun createStudent(@Body student: Student): Student

    @DELETE("students/{id}")
    suspend fun removeStudent(@Path("id") id: Int)
}