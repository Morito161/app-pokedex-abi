package com.example.ciclovidaactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class PokemonAdapter(
    private val pokemonList: List<PokemonRef>,
    private val onPokemonClick: (PokemonRef) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.pokemon_name_text)
        val cardView: CardView = view.findViewById(R.id.pokemon_card_view)
        val imageView: ImageView = view.findViewById(R.id.pokemon_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.nameTextView.text = pokemon.name.replaceFirstChar { it.uppercase() }

        val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemon.getId()}.png"
        holder.imageView.load(imageUrl)

        holder.cardView.setOnClickListener {
            onPokemonClick(pokemon)
        }
    }

    override fun getItemCount() = pokemonList.size
}