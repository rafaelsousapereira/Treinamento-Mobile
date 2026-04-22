package com.treinamentomobile.exercicioudf.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.treinamentomobile.exercicioudf.model.GymStudent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class GymStudentViewModel : ViewModel() {
    private val _state = mutableStateOf(GymStudent())

    val state: State<GymStudent> = _state
    private val _uiEffect = MutableSharedFlow<String>()
    val uiEffect = _uiEffect.asSharedFlow()

    sealed class GymStudentAction {
        data class NameChange(val name: String): GymStudentAction()
        data class AgeChange(val age: Int): GymStudentAction()
        data class RegistrationChange(val registration: Int): GymStudentAction()
        data class RemoveGymStudent(val gymStudent: GymStudent): GymStudentAction()
        data class UpdateGymStudent(val gymStudent: GymStudent): GymStudentAction()
        data object AddGymStudent : GymStudentAction()
    }

    fun onAction(action: GymStudentAction) {
        when(action) {
            is GymStudentAction.NameChange -> {
                _state.value = _state.value.copy(name = action.name)
            }

            is GymStudentAction.AgeChange -> {
                _state.value = _state.value.copy(age = action.age)
            }

            is GymStudentAction.RegistrationChange -> {
                _state.value = _state.value.copy(registration = action.registration)
            }

            is GymStudentAction.AddGymStudent -> {
                val current = _state.value

                val newStudent = GymStudent(
                    name = "",
                    age = 0,
                    registration = 0
                )

                _state.value = current.copy(
                    students = current.students + newStudent,
                    name = "",
                    age = 0,
                    registration = 0
                )

                // Side Effects
                viewModelScope.launch { _uiEffect.emit("Aluno cadastrado com sucesso!") }
            }

            // Remover pessoa
            is GymStudentAction.RemoveGymStudent -> {
                _state.value = _state.value.copy(
                    students = _state.value.students - action.gymStudent
                )

                // Side Effects
                viewModelScope.launch { _uiEffect.emit("Aluno removido com sucesso!") }
            }

            is GymStudentAction.UpdateGymStudent -> TODO()
        }
    }
}