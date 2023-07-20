package ir.minicartoon.shopinglistmvvm

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shoppingItem")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name: String,
    val amount: Int
)
