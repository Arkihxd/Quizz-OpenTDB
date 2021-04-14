package br.edu.ifpr.trabalhoquiz.entidades

data class LoginResponse (
    var sucesso: Boolean,
    var mensagem: String,
    var pontuacao: Int
)