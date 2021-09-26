package com.usati.shoplist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.usati.shoplist.data.db.entities.ShopItem

@Dao
interface ShopDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShopItem)

    @Delete
    suspend fun delete(item: ShopItem)

    @Query("SELECT * FROM shop_items")
    fun getAllShopItems(): LiveData<List<ShopItem>>
}