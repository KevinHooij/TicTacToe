package com.example.tictactoe.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tictactoe.model.GameItem
import com.example.tictactoe.R
import kotlinx.android.synthetic.main.item_games.view.*

class GameAdapter(private val games: List<GameItem>, private val onClick: (GameItem, Int) -> Unit) :
        RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_games, parent, false)
        )
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(games[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { onClick(games[adapterPosition], adapterPosition) }
        }

        fun bind(gameItem: GameItem) {

            itemView.tvName.text = gameItem.nameP2
            itemView.tvId.text = gameItem.id.toString()

            Log.d("adlfjafij", gameItem.toString())
        }
    }
}