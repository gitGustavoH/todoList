package com.example.todolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemTarefaBinding
import com.example.todolist.model.Tarefa

class TarefaAdapter() : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    private var listaTarefas: List<Tarefa> = emptyList()

     fun adicionarLista(lista: List<Tarefa>){
        this.listaTarefas = lista
        notifyDataSetChanged()
    }

    inner class TarefaViewHolder(itemBinding: ItemTarefaBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {

        private val binding: ItemTarefaBinding

        init {
            binding = itemBinding
        }

        fun bind(){
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemTarefaBinding = ItemTarefaBinding.inflate(
            layoutInflater, parent, false
        )
        return TarefaViewHolder(itemTarefaBinding)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = listaTarefas[position]
        holder.bind()
    }

    override fun getItemCount(): Int {
        return listaTarefas.size
    }

}