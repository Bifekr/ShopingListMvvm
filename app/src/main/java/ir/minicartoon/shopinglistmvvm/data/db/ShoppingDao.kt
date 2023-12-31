package ir.minicartoon.shopinglistmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.minicartoon.shopinglistmvvm.data.db.entity.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete()
    suspend fun delete(item: ShoppingItem)

    @Query("Select * From shoppingItem")
     fun getAllShoppingItem():LiveData<List<ShoppingItem>>
}