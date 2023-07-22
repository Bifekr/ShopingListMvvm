package ir.minicartoon.shopinglistmvvm.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ir.minicartoon.shopinglistmvvm.R
import ir.minicartoon.shopinglistmvvm.adapter.ShoppingItemAdapter
import ir.minicartoon.shopinglistmvvm.data.db.ShoppingDataBase
import ir.minicartoon.shopinglistmvvm.data.db.entity.ShoppingItem
import ir.minicartoon.shopinglistmvvm.data.repository.ShoppingRepository
import ir.minicartoon.shopinglistmvvm.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {
    lateinit var binding:ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataBase=ShoppingDataBase(this)
        val repository=ShoppingRepository(dataBase)
        val factory=ShoppingViewModelFactory(repository)

        val viewModel= ViewModelProvider(this,factory)[ShoppingViewModel::class.java]



         val adapter= ShoppingItemAdapter(listOf(),viewModel)
        binding.rv.layoutManager=LinearLayoutManager(this)
        binding.rv.adapter=adapter

        viewModel.getAllShoppingList().observe(this, Observer {
            adapter.item=it
            adapter.notifyDataSetChanged()
        })

        binding.fab.setOnClickListener {
            AddShoppingItemDialog(this,
            object :AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                viewModel.upsert(item)
                }
            }).show()
        }




    }
}