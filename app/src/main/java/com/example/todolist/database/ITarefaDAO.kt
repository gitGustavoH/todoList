package com.example.todolist.database

import com.example.todolist.model.Tarefa

interface ITarefaDAO {

    fun salvar(tarefa: Tarefa): Boolean
    fun atualizar(tarefa: Tarefa): Boolean
    fun remover(idTarefa: Int): Boolean
    fun listar(): List<Tarefa>


}