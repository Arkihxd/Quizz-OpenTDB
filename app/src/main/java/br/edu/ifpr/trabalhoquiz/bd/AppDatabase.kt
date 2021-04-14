package br.edu.ifpr.trabalhoquiz.bd

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.edu.ifpr.trabalhoquiz.bd.dao.PerguntaDao
import br.edu.ifpr.trabalhoquiz.entidades.Converters
import br.edu.ifpr.trabalhoquiz.entidades.Question

@Database(entities = arrayOf(Question::class), version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun perguntaDao(): PerguntaDao
}
