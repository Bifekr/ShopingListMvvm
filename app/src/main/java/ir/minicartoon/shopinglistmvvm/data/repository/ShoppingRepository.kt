package ir.minicartoon.shopinglistmvvm.data.repository

import ir.minicartoon.shopinglistmvvm.data.db.ShoppingDataBase
import ir.minicartoon.shopinglistmvvm.data.db.entity.ShoppingItem

class ShoppingRepository(private val db:ShoppingDataBase) {

    suspend fun upsert(item:ShoppingItem)=db.shoppingDao().upsert(item)
    suspend fun delete(item:ShoppingItem)=db.shoppingDao().delete(item)
    fun getAllShoppingItems()=db.shoppingDao().getAllShoppingItem()
}