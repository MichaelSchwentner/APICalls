package com.example.apicalls.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.apicalls.R
import com.example.apicalls.data.model.GotCharacter

class GotAdapter() : RecyclerView.Adapter<GotAdapter.ItemViewHolder>() {

    private var dataset = listOf<GotCharacter>()

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.got_name_text)
        val family: TextView = view.findViewById(R.id.got_family_text)
        val title: TextView = view.findViewById(R.id.got_title_text)
        val image: ImageView = view.findViewById(R.id.got_image)

    }

    fun submitList(list: List<GotCharacter>){
        dataset = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.got_item, parent, false)

        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val character = dataset[position]

        holder.name.text = character.fullName
        holder.family.text = character.family
        holder.title.text = character.title

        holder.image.load(character.imageUrl) {
            transformations(CircleCropTransformation())
            error(R.drawable.ic_round_broken_image_24)
        }


    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}