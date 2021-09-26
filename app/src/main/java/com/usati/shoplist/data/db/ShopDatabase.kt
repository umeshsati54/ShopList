package com.usati.shoplist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.usati.shoplist.data.db.entities.ShopItem

@Database(entities = [ShopItem::class], version = 1)
abstract class ShopDatabase : RoomDatabase() {
    abstract fun getShopDao(): ShopDao

    companion object{
        private var instance : ShopDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext, ShopDatabase::class.java, "ShopDB.db").build()
    }
}