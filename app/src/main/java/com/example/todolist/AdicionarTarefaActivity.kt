package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolist.databinding.ActivityAdicionarTarefaBinding
import com.example.todolist.databinding.ActivityMainBinding

class AdicionarTarefaActivity : AppCompatActivity() {


    private val biding by lazy {
        ActivityAdicionarTarefaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
    }
}