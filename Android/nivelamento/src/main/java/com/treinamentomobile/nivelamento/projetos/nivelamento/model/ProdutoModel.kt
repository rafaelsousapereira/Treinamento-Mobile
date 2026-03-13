package com.treinamentomobile.nivelamento.projetos.nivelamento.model

import java.util.Scanner

data class Produto(
    val id: Int,
    var nome: String,
    var preco: Double,
    var estoque: Int,
    var descricao: String? = null
)

fun lerLinhaNullable(scanner: Scanner, prompt: String): String? {
    print(prompt)
    return if (scanner.hasNextLine()) scanner.nextLine() else null
}

fun lerStringObrigatorio(scanner: Scanner, prompt: String): String {
    while (true) {
        val entrada = lerLinhaNullable(scanner, prompt)?.trim()
        if (!entrada.isNullOrBlank()) return entrada
        println("Valor obrigatório. Tente novamente.")
    }
}

fun lerIntOrNull(scanner: Scanner): Int? {
    val linha = if (scanner.hasNextLine()) scanner.nextLine() else return null
    return linha.trim().toIntOrNull()
}

fun lerIntObrigatorio(scanner: Scanner, prompt: String): Int {
    while (true) {
        val entrada = lerLinhaNullable(scanner, prompt)?.trim()
        val valor = entrada?.toIntOrNull()
        if (valor != null) return valor
        println("Número inteiro inválido. Tente novamente.")
    }
}

fun lerDoubleObrigatorio(scanner: Scanner, prompt: String): Double {
    while (true) {
        val entrada = lerLinhaNullable(scanner, prompt)?.trim()
        val valor = entrada?.replace(",", ".")?.toDoubleOrNull()
        if (valor != null) return valor
        println("Número decimal inválido. Tente novamente.")
    }
}
