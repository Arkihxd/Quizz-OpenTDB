package br.edu.ifpr.trabalhoquiz.ui

import br.edu.ifpr.trabalhoquiz.entidades.Categoria

interface CategoriaListListener {
    fun getCategoria(categoria: Categoria)
}