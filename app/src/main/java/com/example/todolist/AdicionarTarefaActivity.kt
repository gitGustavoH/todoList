package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todolist.database.TarefaDAO
import com.example.todolist.databinding.ActivityAdicionarTarefaBinding
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.model.Tarefa

class AdicionarTarefaActivity : AppCompatActivity() {


    private val biding by lazy {
        ActivityAdicionarTarefaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)

        biding.btnSalvar.setOnClickListener {
            if (biding.editTarefa.text.isNotEmpty()){

                val descricao = biding.editTarefa.text.toString()
                val tarefa = Tarefa(
                    0, descricao, "default"
                )

                val tarefaDAO = TarefaDAO(this)
               if (tarefaDAO.salvar(tarefa)){
                   Toast.makeText(this,
                       "Tarefa cadastrada com sucesso",
                       Toast.LENGTH_SHORT).show()
                   finish()
               }
            }else{
                Toast.makeText(this,
                    "Preencha uma tarefa",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun salvar() {

    }
}