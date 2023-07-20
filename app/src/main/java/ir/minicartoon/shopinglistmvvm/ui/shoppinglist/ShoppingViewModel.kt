package ir.minicartoon.shopinglistmvvm.ui.shoppinglist

import androidx.lifecycle.ViewModel
import ir.minicartoon.shopinglistmvvm.data.db.entity.ShoppingItem
import ir.minicartoon.shopinglistmvvm.data.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository): ViewModel() {

  //dont use suspend because inside the function we will execute courting
    fun upsert(item: ShoppingItem)= CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
  }

    fun delete(item:ShoppingItem)= CoroutineScope(Dispatchers.Main).launch { repository.delete(item) }
    fun getAllShoppingList()=repository.getAllShoppingItems()
}