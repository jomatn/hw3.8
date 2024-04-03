package com.example.hw38

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw38.databinding.CardItemBinding

class CardAdapter(private val cardList: List<Card>) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int = cardList.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cardList[position]
        holder.bind(card)
        holder.itemView.setOnClickListener {
            listener?.onItemClick(card)
        }
    }


    class CardViewHolder(private val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.apply {
                tvName.text = card.name
                tvStatus.text = card.status
                Glide.with(itemView).load(card.image)
            }
        }
    }
}
