package com.treinamentomobile.projetosqlite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.treinamentomobile.projetosqlite.data.database.AppDatabase
import com.treinamentomobile.projetosqlite.data.entity.Address
import com.treinamentomobile.projetosqlite.data.entity.Person
import com.treinamentomobile.projetosqlite.ui.theme.ProjetoSQLiteTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Testar SQLite
        val db = AppDatabase.getDatabase(applicationContext)
        val personDao = db.personDao()
        val addressDao = db.addressDao()

        lifecycleScope.launch(Dispatchers.IO) {

//            addressDao.insert(Address(street = "Avenida Tiradentes", city =  "Curitiba", personId = 1))
//            addressDao.insert(Address(street = "Avenida Paulista", city =  "São Paulo", personId = 2))
//            addressDao.insert(Address(street = "Centro", city = "Rio de Janeiro", personId = 3))


            personDao.getPersonsAddresses().collect { list ->
                list.forEach { item ->
                    item.address.forEach { address ->
                        println(
                            "Pessoa -> " +
                            " Nome: ${item.person.name}" +
                            " | Idade: ${item.person.age}" +
                            " | Endereço: ${address.city}"
                        )
                    }
                }
            }

//            personDao.insert(Person(name = "Sara", age = 42))
//
//            personDao.update(Person(id = 6, name = "Ana", age = 19))
//
//            personDao.getAll().collect { persons ->
//                persons.forEach { person ->
//                    println("Pessoa -> ${person.name} - ${person.age}")
//                }
//            }


        }

        enableEdgeToEdge()
        setContent {
            ProjetoSQLiteTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjetoSQLiteTheme {
        Greeting("Android")
    }
}