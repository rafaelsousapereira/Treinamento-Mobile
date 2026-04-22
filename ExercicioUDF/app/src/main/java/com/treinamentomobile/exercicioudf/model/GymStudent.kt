package com.treinamentomobile.exercicioudf.model

import java.util.UUID

data class GymStudent(
    val id: UUID = UUID.randomUUID(),
    val name: String = "",
    val age: Int = 0,
    val registration: Int = 0,
    val students: List<GymStudent> = emptyList()
)
