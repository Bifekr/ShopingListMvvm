package ir.minicartoon.shopinglistmvvm.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import ir.minicartoon.shopinglistmvvm.data.db.entity.ShoppingItem
import ir.minicartoon.shopinglistmvvm.databinding.DialogAddShoppingItemBinding

class AddShoppingItemDialog(context: Context,var addDialogListener: AddDialogListener) :AppCompatDialog(context){

    lateinit var binding:DialogAddShoppingItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvAdd.setOnClickListener{
            val name=binding.etName.text.toString()
            val amount=binding.etAmount.text.toString()



            var item=ShoppingItem(name = name,amount = amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }


    }


}