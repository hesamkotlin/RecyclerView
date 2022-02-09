package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ContactsAdapter(
    private val ContactList: List<Contact>,
    private val onItemDeleted: (position: Int) -> Unit
) : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvName = itemView.findViewById<TextView>(R.id.tv_name)
        private val tvPhone = itemView.findViewById<TextView>(R.id.tv_phone)
        private val ivImage = itemView.findViewById<ImageView>(R.id.iv_profile)
        private val ibDelete = itemView.findViewById<TextView>(R.id.ib_delete)

        init {
            ibDelete.setOnClickListener() {
                onItemDeleted(bindingAdapterPosition)
            }
        }

        fun bind(contact: Contact) {
            tvName.text = contact.name
            tvPhone.text = contact.phone
            //ivImage.setImageResource(contact.image)
            Glide.with(ivImage.context).load(contact.image).into(ivImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(ContactList[position])
    }

    override fun getItemCount(): Int {
        return ContactList.count()
    }

}
