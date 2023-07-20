package ir.minicartoon.shopinglistmvvm.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shoppingItem")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name: String,
    val amount: Int
)
