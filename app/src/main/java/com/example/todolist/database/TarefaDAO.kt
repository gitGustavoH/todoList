package com.example.todolist.database

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.todolist.model.Tarefa

class TarefaDAO(context: Context) : ITarefaDAO {

    private val escrita = DataBaseHelper(context).writableDatabase
    private val leitura = DataBaseHelper(context).readableDatabase

    override fun salvar(tarefa: Tarefa): Boolean {

        val conteudo = ContentValues()
        conteudo.put("${DataBaseHelper.COLUNA_DESCRICAO}", tarefa.descricao)

        try {
            escrita.insert(
                DataBaseHelper.NOME_TABELA_TAREFAS,
                null,
                conteudo
            )
            Log.i("info_db", "Sucesso ao salvar tarefa")
        }catch (e: Exception){
            Log.i("info_db", "Erro ao salvar tarefa")
            return false
        }
        return true
    }

    override fun atualizar(tarefa: Tarefa): Boolean {
        TODO("Not yet implemented")
    }

    override fun remover(idTarefa: Tarefa): Boolean {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Tarefa> {

        val listaTarefas = mutableListOf<Tarefa>()

        val sql = "SELECT ${DataBaseHelper.COLUNA_ID_TAREFA}, " +
                "${DataBaseHelper.COLUNA_DESCRICAO}, " +
                "strftime('%d/%m/%y %H:%M', ${DataBaseHelper.COLUNA_DATA_CADASTRO}) ${DataBaseHelper.COLUNA_DATA_CADASTRO} " +
                "FROM ${DataBaseHelper.NOME_TABELA_TAREFAS}"

        val cursor = leitura.rawQuery(sql, null)

        val indiceId = cursor.getColumnIndex(DataBaseHelper.COLUNA_ID_TAREFA)
        val indiceDescricao = cursor.getColumnIndex(DataBaseHelper.COLUNA_DESCRICAO)
        val indiceData = cursor.getColumnIndex(DataBaseHelper.COLUNA_DATA_CADASTRO)

        if (indiceId != -1 && indiceDescricao != -1 && indiceData != -1) {

            while (cursor.moveToNext()) {
            val idTarefa = cursor.getInt(indiceId)
            val descricao = cursor.getString(indiceDescricao)
            val data = cursor.getString(indiceData)

            listaTarefas.add(
                Tarefa(idTarefa, descricao, data)
            )
        }}else {
            Log.i("info_db", "1 coluna ou mais estao invalidas")
        }

        return listaTarefas

    }

}