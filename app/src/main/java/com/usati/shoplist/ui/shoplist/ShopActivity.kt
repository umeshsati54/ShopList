package com.usati.shoplist.ui.shoplist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.usati.shoplist.R
import com.usati.shoplist.data.db.ShopDatabase
import com.usati.shoplist.data.db.entities.ShopItem
import com.usati.shoplist.data.repositories.ShopRepository
import com.usati.shoplist.other.ShopItemAdapter
import kotlinx.android.synthetic.main.activity_shop.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ShopActivity : AppCompatActivity()//, KodeinAware
{
    //override val kodein by kodein()
    //private val factory: ShopViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        val database = ShopDatabase(this)
        val repository = ShopRepository(database)
        val factory = ShopViewModelFactory(repository)

        val viewModel = ViewModelProvider(this,factory).get(ShopViewModel::class.java)

        val adapter = ShopItemAdapter(listOf(), viewModel)

        rvShopItem.layoutManager = LinearLayoutManager(this)
        rvShopItem.adapter = adapter

        viewModel.getAllShopItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            val bottomSheetDialog = BottomDialogFragment(this, object : AddDialogListener{
                override fun addOnAddButtonClicked(item: ShopItem) {
                    viewModel.upsert(item)
                }
            })
            bottomSheetDialog.show(supportFragmentManager,bottomSheetDialog.tag)
        }


    }
}