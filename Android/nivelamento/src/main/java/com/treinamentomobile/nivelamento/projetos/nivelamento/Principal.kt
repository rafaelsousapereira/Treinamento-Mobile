package com.treinamentomobile.nivelamento.projetos.nivelamento

import com.treinamentomobile.nivelamento.projetos.nivelamento.service.ProdutoService
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val service = ProdutoService()

    while (true) {
        println("\n========= MENU =========")
        println("A) Cadastrar")
        println("B) Listar")
        println("C) Pesquisar")
        println("D) Alterar")
        println("E) Remover")
        println("F) Finalizar")
        print("Escolha uma opção: ")

        val opcao = if (scanner.hasNextLine()) scanner.nextLine().trim().uppercase() else "F"

        when (opcao) {
            "A" -> service.cadastrar(scanner)
            "B" -> service.listar()
            "C" -> service.pesquisar(scanner)
            "D" -> service.alterar(scanner)
            "E" -> service.remover(scanner)
            "F" -> { service.finalizar(); break }
            else -> println("Opção inválida. Escolha entre A e F.")
        }
    }
}