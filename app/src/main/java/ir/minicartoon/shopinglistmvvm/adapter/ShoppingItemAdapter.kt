package ir.minicartoon.shopinglistmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.minicartoon.shopinglistmvvm.R
import ir.minicartoon.shopinglistmvvm.data.db.entity.ShoppingItem
import ir.minicartoon.shopinglistmvvm.databinding.SoppingItemBinding
import ir.minicartoon.shopinglistmvvm.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var item:List<ShoppingItem>,
    private val viewModel:ShoppingViewModel
) :RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val binding =SoppingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentItem=item[position]
        holder.bind(currentItem)

    }

    override fun getItemCount(): Int {
       return item.size
    }

    inner class ShoppingViewHolder(private var binding: SoppingItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item :ShoppingItem){
            binding.tvName.text = item.name
            binding.tvAmount.text="${item.amount}"
            binding.ivDelete.setOnClickListener{
                viewModel.delete(item)
            }
            binding.ivMinus.setOnClickListener{
                item.amount--
                viewModel.upsert(item)
            }
            binding.ivPlus.setOnClickListener{

                item.amount++
                viewModel.upsert(item)
            }
        }
    }

}