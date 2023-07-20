package ir.minicartoon.shopinglistmvvm

import android.content.Context
import android.icu.util.VersionInfo
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDataBase :RoomDatabase() {

    abstract fun shoppingDao():ShoppingDao


    companion object{
        
        @Volatile //made visibility for other threads?because one thread at a time writing dataBase
        private var instance:ShoppingDataBase?=null
        private val LOCK=Any()

        //operator = when call ShoppingDataBase() operator function that be executed
        //synchronized = make sure no other threads will access hat instance
        operator fun invoke(context: Context)= instance?: synchronized(LOCK){
            //check again if null
            instance?: createDatabase(context).also { instance=it }
        }

        //instantiates ure database
        private fun createDatabase(context: Context)=
            Room.databaseBuilder(context,
            ShoppingDataBase::class.java,
            "shoppingDB.db").build()


    }


   /* private fun createDatabase(context: Context) {
        Room.databaseBuilder(
            context,
            ShoppingDataBase::class.java,
            "shoppingDB.db").build()
    }*/


}