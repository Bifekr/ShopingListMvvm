package ir.minicartoon.shopinglistmvvm.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ir.minicartoon.shopinglistmvvm.R
import ir.minicartoon.shopinglistmvvm.data.db.ShoppingDataBase
import ir.minicartoon.shopinglistmvvm.data.repository.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val dataBase=ShoppingDataBase(this)
        val repository=ShoppingRepository(dataBase)
        val factory=ShoppingViewModelFactory(repository)

        val viewModel= ViewModelProvider(this,factory)[ShoppingViewModel::class.java]
    }
}