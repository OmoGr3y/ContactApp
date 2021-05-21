package com.toor.contactapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.toor.contactapp.databinding.ContactListItemsBinding

class ContactAdapter:RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private val contacts =  mutableListOf<Contact>()



    fun setUpContacts(contact:List<Contact>){
        contacts.addAll(contact)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(ContactListItemsBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bindItem(contact)

    }

    override fun getItemCount(): Int {
        return  contacts.size
    }

    inner class ContactViewHolder(private val binding: ContactListItemsBinding ):RecyclerView.ViewHolder(binding.root){
        fun  bindItem(contact: Contact){
            binding.name.text = contact.name
            binding.number.text = contact.number
        }
    }
}