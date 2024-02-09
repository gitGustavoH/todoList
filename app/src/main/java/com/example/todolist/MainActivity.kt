package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.adapter.TarefaAdapter
import com.example.todolist.database.TarefaDAO
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.model.Tarefa

class MainActivity : AppCompatActivity() {

    private val biding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var listaTarefa = emptyList<Tarefa>()
    private var tarefaAdapter: TarefaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)

        biding.fabAdicionar.setOnClickListener {
            val intent = Intent(this, AdicionarTarefaActivity::class.java)
            startActivity(intent)
        }

        // recycle review
        tarefaAdapter = TarefaAdapter()
        biding.rvTarefas.adapter = tarefaAdapter

        biding.rvTarefas.layoutManager = LinearLayoutManager(this)

    }

    private fun atualizarListaTarefas(){
        val tarefaDAO = TarefaDAO(this)
        listaTarefa = tarefaDAO.listar()
        tarefaAdapter?.adicionarLista(listaTarefa)
    }
    override fun onStart() {
        super.onStart()

        atualizarListaTarefas()
    }

}