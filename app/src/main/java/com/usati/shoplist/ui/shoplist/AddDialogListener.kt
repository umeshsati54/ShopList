package com.usati.shoplist.ui.shoplist

import com.usati.shoplist.data.db.entities.ShopItem

interface AddDialogListener {
    fun addOnAddButtonClicked(item: ShopItem)
}