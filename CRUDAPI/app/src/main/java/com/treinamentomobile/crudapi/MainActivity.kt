package com.treinamentomobile.crudapi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.treinamentomobile.crudapi.data.dao.AppDatabase
import com.treinamentomobile.crudapi.data.model.Contact
import com.treinamentomobile.crudapi.data.remote.RetrofitClient
import com.treinamentomobile.crudapi.data.repository.ContactRepository
import com.treinamentomobile.crudapi.ui.components.DatePickerFieldToModal
import com.treinamentomobile.crudapi.ui.theme.CRUDAPITheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {

    private val database by lazy { AppDatabase.getDatabase(this) }
    private val repository by lazy { ContactRepository(database.contactDao()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CRUDAPITheme {
                AppDataScreen(repository)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDataScreen(repository: ContactRepository) {

    var contacts by remember { mutableStateOf(emptyList<Contact>()) }

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var birthday by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }

    // Estados para os campos que virão do ViaCEP
    var street by remember { mutableStateOf("") }
    var neighborhood by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }

    // Estado para saber se estamos editando um contato
    var editingContact by remember { mutableStateOf<Contact?>(null) }
    val scope: CoroutineScope = rememberCoroutineScope()
    val dateFormatter = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }

    fun refreshContacts() {
        scope.launch {
            contacts = repository.getContacts()
        }
    }

    fun clearFields() {
        name = ""
        email = ""
        phone = ""
        birthday = ""
        cep = ""
        number = ""
        street = ""
        neighborhood = ""
        city = ""
        state = ""
        editingContact = null
    }

    LaunchedEffect(Unit) {
        refreshContacts()
    }

    LaunchedEffect(cep) {
        if (cep.length == 8) {
            try {
                val response = RetrofitClient.api.getAddress(cep)
                street = response.street
                neighborhood = response.neighborhood
                city = response.city
                state = response.state
            } catch (e: Exception) {
                Log.e("ViaCEP", "Erro ao buscar CEP", e)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = if (editingContact == null) "Cadastro de Contatos" else "Editar Contato",
            modifier = Modifier.padding(bottom = 16.dp),
            style = MaterialTheme.typography.headlineLarge
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nome") },
            modifier = Modifier.padding(bottom = 10.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.padding(bottom = 10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
        )
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Telefone") },
            modifier = Modifier.padding(bottom = 10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone)
        )
        DatePickerFieldToModal(
            value = birthday,
            onValueChange = { birthday = it },
            label = { Text("Data de Nascimento") },
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 36.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                value = cep,
                onValueChange = { if (it.length <= 8) cep = it },
                label = { Text("CEP") },
                modifier = Modifier.weight(3f),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                singleLine = true
            )

            OutlinedTextField(
                value = number,
                onValueChange = { number = it },
                label = { Text("Número") },
                modifier = Modifier.weight(2f),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                singleLine = true
            )
        }

        if (street.isNotEmpty()) {
            Text(
                text = "$street, $neighborhood - $city/$state",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .padding(horizontal = 48.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (editingContact != null) {
                Button(
                    onClick = { clearFields() },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                ) {
                    Text("Cancelar")
                }
            }

            Button(
                onClick = {
                    scope.launch {
                        val parsedDate = try {
                            dateFormatter.parse(birthday)
                        } catch (e: Exception) {
                            null
                        }

                        val contact = Contact(
                            id = editingContact?.id ?: 0,
                            name = name,
                            email = email,
                            phone = phone,
                            birthday = parsedDate ?: Date(),
                            cep = cep,
                            street = street,
                            number = number.toIntOrNull() ?: 0,
                            complement = "",
                            neighborhood = neighborhood,
                            city = city,
                            state = state
                        )

                        if (editingContact == null) {
                            repository.addContact(contact)
                        } else {
                            repository.updateContact(contact)
                        }

                        clearFields()
                        refreshContacts()
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(if (editingContact == null) "Cadastrar" else "Atualizar")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(contacts) { contact ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = contact.name, style = MaterialTheme.typography.titleMedium)
                            Text(
                                text = "Email: ${contact.email}",
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = "Data de Nascimento: ${dateFormatter.format(contact.birthday)}",
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = "Endereço: ${contact.street}, ${contact.neighborhood} - ${contact.number}, ${contact.city}/${contact.state}",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }

                        Row {
                            IconButton(onClick = {
                                editingContact = contact
                                name = contact.name
                                email = contact.email
                                phone = contact.phone
                                birthday = dateFormatter.format(contact.birthday)
                                cep = contact.cep ?: ""
                                number = contact.number.toString()
                                street = contact.street
                                neighborhood = contact.neighborhood
                                city = contact.city
                                state = contact.state
                            }) {
                                Icon(
                                    Icons.Default.Edit,
                                    contentDescription = "Editar",
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                            IconButton(onClick = {
                                scope.launch {
                                    repository.deleteContact(contact)
                                    refreshContacts()
                                }
                            }) {
                                Icon(
                                    Icons.Default.Delete,
                                    contentDescription = "Remover",
                                    tint = MaterialTheme.colorScheme.error
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
