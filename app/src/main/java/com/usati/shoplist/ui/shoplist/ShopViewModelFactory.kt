package com.usati.shoplist.ui.shoplist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.usati.shoplist.data.repositories.ShopRepository

class ShopViewModelFactory(
    private val repository: ShopRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShopViewModel(repository) as T
    }

}