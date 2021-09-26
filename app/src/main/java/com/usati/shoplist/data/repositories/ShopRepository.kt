package com.usati.shoplist.data.repositories

import com.usati.shoplist.data.db.ShopDatabase
import com.usati.shoplist.data.db.entities.ShopItem

class ShopRepository(private val db: ShopDatabase) {
    suspend fun upsert(item: ShopItem) = db.getShopDao().upsert(item)
    suspend fun delete(item: ShopItem) = db.getShopDao().delete(item)
    fun getAllShopItems() = db.getShopDao().getAllShopItems()
}