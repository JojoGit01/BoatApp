package com.example.app.ui.restaurants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemBinding
import com.example.app.ui.restaurants.CellClickListener


class RestaurantAdapter(val items: Array<Restaurant>, var listener : CellClickListener) : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindAndVersion(restaurant: Restaurant) {
            with(restaurant) {
                binding.image.setImageResource(image)
                binding.nom.text =  "$nom"
                binding.lieu.text = "$lieu"
                binding.horaire.text = "$horaire"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantAdapter.ViewHolder {
        return ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindAndVersion(items[position])
        holder.itemView.setOnClickListener {
            listener.onCellClickListener(items[position].nom)
        }
    }

    override fun getItemCount(): Int = items.size

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

}