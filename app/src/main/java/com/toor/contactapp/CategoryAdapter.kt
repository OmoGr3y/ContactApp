package com.toor.contactapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.toor.contactapp.databinding.ContactListBinding

class CategoryAdapter:RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val categories = mutableListOf<Category>()

    fun setUpCategories(category:List<Category>){
        this.categories.addAll(category)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ContactListBinding.inflate(
                LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bindItem(category)
    }

    override fun getItemCount(): Int {
        return categories.size
    }


    inner class CategoryViewHolder(private val binding: ContactListBinding):RecyclerView.ViewHolder(binding.root){
        fun  bindItem(category: Category){
            binding.category.text = category.name
        }
    }
}