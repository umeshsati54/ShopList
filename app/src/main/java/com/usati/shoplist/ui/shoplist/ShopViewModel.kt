package com.usati.shoplist.ui.shoplist

import androidx.lifecycle.ViewModel
import com.usati.shoplist.data.db.entities.ShopItem
import com.usati.shoplist.data.repositories.ShopRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShopViewModel(private val repository: ShopRepository) : ViewModel() {
    fun upsert(item: ShopItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }
    fun delete(item: ShopItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }
    fun getAllShopItems() = repository.getAllShopItems()
}