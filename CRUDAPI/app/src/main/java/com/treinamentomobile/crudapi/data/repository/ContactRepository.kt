package com.treinamentomobile.crudapi.data.repository

import com.treinamentomobile.crudapi.data.dao.ContactDao
import com.treinamentomobile.crudapi.data.model.Contact

class ContactRepository(private val contactDao: ContactDao) {

    suspend fun getContacts(): List<Contact> {
        return contactDao.getAllContacts()
    }

    suspend fun addContact(contact: Contact) {
        contactDao.insertContact(contact)
    }

    suspend fun updateContact(contact: Contact) {
        contactDao.updateContact(contact)
    }

    suspend fun deleteContact(contact: Contact) {
        contactDao.deleteContact(contact)
    }
}