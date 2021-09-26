package com.usati.shoplist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.usati.shoplist.R
import com.usati.shoplist.data.db.entities.ShopItem
import com.usati.shoplist.ui.shoplist.ShopViewModel
import kotlinx.android.synthetic.main.shop_item.view.*

class ShopItemAdapter(
    var items: List<ShopItem>,
    var viewModel: ShopViewModel,
) : RecyclerView.Adapter<ShopItemAdapter.ShopViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_item, parent, false)
        return ShopViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val curShopItem = items[position]
        holder.itemView.tvName.text = curShopItem.name
        holder.itemView.tvAmount.text = "${curShopItem.amount}"

        holder.itemView.add.setOnClickListener {
            curShopItem.amount++
            viewModel.upsert(curShopItem)
        }

        holder.itemView.remove.setOnClickListener {
            if (curShopItem.amount > 0) {
                curShopItem.amount--
                viewModel.upsert(curShopItem)
            }
        }

        holder.itemView.delete.setOnClickListener {
            viewModel.delete(curShopItem)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShopViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}