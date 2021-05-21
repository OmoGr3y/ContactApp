package com.toor.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.toor.contactapp.databinding.ActivityMainBinding
import com.toor.contactapp.databinding.ContactListBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    private val adapter = CategoryAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpData(binding)
    }

    private fun setUpData(binding: ActivityMainBinding) {
        binding.categoryRecyclerView.adapter = adapter
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.add_category_dialog, null)
        builder.setView(view)

        val categoryEt = view.findViewById<TextView>(R.id.categoryEt)
        val addBtn = view.findViewById<TextView>(R.id.addBt)

        val alertDialog = builder.create()

        addBtn.setOnClickListener{
            val category = Category(categoryEt.text.toString())
            val categories = mutableListOf(category)
            adapter.setUpCategories(categories)
            alertDialog.dismiss()

        }



        binding.fab.setOnClickListener{
            alertDialog.show()
        }


    }


}