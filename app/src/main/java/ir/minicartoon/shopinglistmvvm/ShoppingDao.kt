package ir.minicartoon.shopinglistmvvm

import android.icu.text.Replaceable
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete()
    suspend fun delete(item: ShoppingItem)

    @Query("Select * From shoppingItem")
    suspend fun getAllShoppingItem():LiveData<List<ShoppingItem>>
}