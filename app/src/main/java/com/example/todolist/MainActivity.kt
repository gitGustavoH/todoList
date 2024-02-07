package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.todolist.database.TarefaDAO
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.model.Tarefa

class MainActivity : AppCompatActivity() {

    private val biding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var listaTarefa = emptyList<Tarefa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)

        biding.fabAdicionar.setOnClickListener {
            val intent = Intent(this, AdicionarTarefaActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
      //  setContentView(biding.root)

        val tarefaDAO = TarefaDAO(this)
        listaTarefa = tarefaDAO.listar()

        listaTarefa.forEach{ tarefa ->
            Log.i("info_db", "${tarefa.descricao} \n")
        }

    }

}