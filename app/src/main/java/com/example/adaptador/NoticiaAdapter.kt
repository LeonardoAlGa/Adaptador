package com.example.adaptador

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adaptador.databinding.ItemListBinding

class NoticiaAdapter(val noticias: List<Noticia>, val onNoticiaClicked: (Noticia) -> Unit) : RecyclerView.Adapter<NoticiaHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoticiaHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater, parent, false)
        return NoticiaHolder(binding)

    }

    override fun onBindViewHolder(
        holder: NoticiaHolder,
        position: Int
    ) {
        val noticia = noticias[position]
        holder.binding.tvwTitle.text = noticia.title
        holder.binding.tvwDescription.text = noticia.description
        holder.binding.root.setOnClickListener { onNoticiaClicked(noticia) }

    }

    override fun getItemCount()=noticias.size

}