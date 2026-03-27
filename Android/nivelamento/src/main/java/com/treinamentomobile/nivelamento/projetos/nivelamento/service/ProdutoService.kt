package com.treinamentomobile.nivelamento.projetos.nivelamento.service

import com.treinamentomobile.nivelamento.projetos.nivelamento.model.Produto
import com.treinamentomobile.nivelamento.projetos.nivelamento.model.lerDoubleObrigatorio
import com.treinamentomobile.nivelamento.projetos.nivelamento.model.lerIntObrigatorio
import com.treinamentomobile.nivelamento.projetos.nivelamento.model.lerIntOrNull
import com.treinamentomobile.nivelamento.projetos.nivelamento.model.lerLinhaNullable
import com.treinamentomobile.nivelamento.projetos.nivelamento.model.lerStringObrigatorio
import java.util.Scanner

class ProdutoService {
    private val produtos = mutableListOf<Produto>()

    fun cadastrar(scanner: Scanner) {
        println("\n=== CADASTRAR PRODUTO ===")

        val id = lerIntObrigatorio(scanner, "Informe o ID (número inteiro): ")
        if (produtos.any { it.id == id }) {
            println("Erro: já existe produto com ID $id.")
            return
        }

        val nome = lerStringObrigatorio(scanner, "Informe o nome: ")
        val preco = lerDoubleObrigatorio(scanner, "Informe o preço (ex: 10.50): ")
        if (preco <= 0.0) {
            println("Erro: preço deve ser maior que 0.")
            return
        }

        val estoque = lerIntObrigatorio(scanner, "Informe o estoque (>= 0): ")
        if (estoque < 0) {
            println("Erro: estoque não pode ser negativo.")
            return
        }

        val descInput: String? = lerLinhaNullable(scanner, "Descrição (opcional, ENTER para pular): ")
        val descricaoFinal = descInput?.takeIf { it.isNotBlank() } ?: "Sem descrição"

        val produto = Produto(
            id = id,
            nome = nome,
            preco = preco,
            estoque = estoque,
            descricao = descricaoFinal
        )

        produtos.add(produto)
        println("Produto cadastrado com sucesso!")
    }

    fun listar() {
        println("\n=== LISTAR PRODUTOS ===")

        if (produtos.isEmpty()) {
            println("Nenhum produto cadastrado.")
            return
        }

        produtos.forEach { p ->
            val desc = p.descricao?.takeIf { it.isNotBlank() } ?: "Sem descrição"
            println("ID: ${p.id} | Nome: ${p.nome} | Preço: ${"%.2f".format(p.preco)} | Estoque: ${p.estoque} | Desc: $desc")
        }
    }

    fun pesquisar(scanner: Scanner) {
        println("\n=== PESQUISAR PRODUTO ===")
        println("1 - Buscar por ID")
        println("2 - Buscar por nome (contém)")
        print("Escolha: ")

        val opcao = lerIntOrNull(scanner) ?: run {
            println("Opção inválida.")
            return
        }

        when (opcao) {
            1 -> {
                val id = lerIntObrigatorio(scanner, "Informe o ID: ")
                val produto = produtos.find { it.id == id }

                if (produto == null) {
                    println("Produto não encontrado.")
                } else {
                    println("Encontrado: $produto")
                }
            }
            2 -> {
                val termo = lerStringObrigatorio(scanner, "Informe parte do nome: ").lowercase()
                val encontrados = produtos.filter { it.nome.lowercase().contains(termo) }

                if (encontrados.isEmpty()) {
                    println("Nenhum produto encontrado.")
                } else {
                    println("Encontrados:")
                    encontrados.forEach { println(it) }
                }
            }
            else -> println("Opção inválida.")
        }
    }

    fun alterar(scanner: Scanner) {
        println("\n=== ALTERAR PRODUTO ===")
        val id = lerIntObrigatorio(scanner, "Informe o ID do produto: ")

        val produto = produtos.find { it.id == id }
        if (produto == null) {
            println("Produto não encontrado.")
            return
        }

        println("Produto atual: $produto")
        println("Dica: pressione ENTER para manter o valor atual.\n")

        val novoNome = lerLinhaNullable(scanner, "Novo nome (${produto.nome}): ")
        if (!novoNome.isNullOrBlank()) {
            produto.nome = novoNome
        }

        val novoPrecoStr = lerLinhaNullable(scanner, "Novo preço (${produto.preco}): ")
        if (!novoPrecoStr.isNullOrBlank()) {
            val novoPreco = novoPrecoStr.toDoubleOrNull()
            if (novoPreco == null || novoPreco <= 0.0) {
                println("Preço inválido. Alteração de preço ignorada.")
            } else {
                produto.preco = novoPreco
            }
        }

        val novoEstoqueStr = lerLinhaNullable(scanner, "Novo estoque (${produto.estoque}): ")
        if (!novoEstoqueStr.isNullOrBlank()) {
            val novoEstoque = novoEstoqueStr.toIntOrNull()
            if (novoEstoque == null || novoEstoque < 0) {
                println("Estoque inválido. Alteração de estoque ignorada.")
            } else {
                produto.estoque = novoEstoque
            }
        }

        val novaDescricao = lerLinhaNullable(scanner, "Nova descrição (${produto.descricao ?: "Sem descrição"}): ")
        produto.descricao = novaDescricao?.takeIf { it.isNotBlank() } ?: produto.descricao

        println("Produto atualizado: $produto")
    }

    fun remover(scanner: Scanner) {
        println("\n=== REMOVER PRODUTO ===")
        val id = lerIntObrigatorio(scanner, "Informe o ID: ")

        val removido = produtos.removeIf { it.id == id }
        if (removido) println("Produto removido com sucesso!")
        else println("Produto não encontrado.")
    }

    fun finalizar() {
        println("\nEncerrando o sistema... Até mais!")
    }
}