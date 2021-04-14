package br.edu.ifpr.trabalhoquiz.entidades

data class QuestionsResponse (
    var response_code: Int,
    var results: List<Question>
)