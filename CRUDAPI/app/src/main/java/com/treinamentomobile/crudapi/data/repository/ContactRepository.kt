package com.treinamentomobile.crudapi.data.repository

import com.treinamentomobile.crudapi.data.model.Contact
import com.treinamentomobile.crudapi.data.remote.RetrofitClient

class ContactRepository {

    suspend fun getContact(): List<Contact> {
        return RetrofitClient.api.getContacts()
    }

    suspend fun addContact(contact: Contact): Contact {
        return RetrofitClient.api.createContact(contact)
    }

    suspend fun updateContact(id: Int, contact: Contact): Contact {
        return RetrofitClient.api.updateContact(id, contact)
    }

    suspend fun deleteContact(id: Int) {
        return RetrofitClient.api.deleteContact(id)
    }
}