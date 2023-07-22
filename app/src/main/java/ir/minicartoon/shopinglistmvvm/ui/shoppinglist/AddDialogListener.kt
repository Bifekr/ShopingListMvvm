package ir.minicartoon.shopinglistmvvm.ui.shoppinglist

import ir.minicartoon.shopinglistmvvm.data.db.entity.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item:ShoppingItem)
}