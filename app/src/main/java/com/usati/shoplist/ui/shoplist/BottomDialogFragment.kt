package com.usati.shoplist.ui.shoplist

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.usati.shoplist.R
import com.usati.shoplist.data.db.entities.ShopItem
import kotlinx.android.synthetic.main.fragment_bottom_dialog.*
import kotlinx.android.synthetic.main.fragment_bottom_dialog.view.*


class BottomDialogFragment(context: Context, var addDialogListener: AddDialogListener) : BottomSheetDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_bottom_dialog, container, false)

        view.add.setOnClickListener {
            val name = name.text.toString()
            val amount = amount.text.toString()

            if (name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context, "Please enter all the information", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val item = ShopItem(name, amount.toInt())
            addDialogListener.addOnAddButtonClicked(item)
            dismiss()
        }

        view.cancel.setOnClickListener {
            dismiss()
        }

        return view
    }

}