package com.treinamentomobile.exemplolivedata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.treinamentomobile.exemplolivedata.model.IncrementModel

class IncrementViewModel {
    // Referência do modelo
    private val _obj = MutableLiveData(IncrementModel())

    // Referência para a visão (View)
    val obj: LiveData<IncrementModel> = _obj

    // Função para incrementar o counter
    fun incrementCounter() {
        // Criar uma cópia do estado atual do objeto
        val currentObj = _obj.value ?: IncrementModel()

        // Criar uma cópia e sobrescrever o _obj
        _obj.value = currentObj.copy(counter = currentObj.counter + 1)
    }

}