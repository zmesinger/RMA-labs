package com.example.inventory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.data.Item
import com.example.inventory.databinding.ItemListItemBinding
import kotlinx.coroutines.flow.Flow


class RecyclerViewAdapter : RecyclerView.Adapter<ItemListViewHolder>() {

    private val items = mutableListOf<Item>()

    fun setItems(items: List<Item>){
        this.items.clear()
        this.items.addAll(items)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_item, parent, false)
        return ItemListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}

class ItemListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Item){
        val binding = ItemListItemBinding.bind(itemView)
        binding.itemName.text = item.itemName
        binding.itemPrice.text = item.itemPrice.toString()
        binding.itemQuantity.text = item.quantityInStock.toString()

    }

}
