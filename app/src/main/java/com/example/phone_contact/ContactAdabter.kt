package com.example.phone_contact

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ContactAdabter(var contact:ArrayList<Contact>): Adapter<ContactAdabter.MyViewHoder>() {
//lateinit var onclick:OnClickItem
    class MyViewHoder(itemView:View):ViewHolder(itemView){
        var name:TextView=itemView.findViewById(R.id.name)
        var num:TextView=itemView.findViewById(R.id.TvId)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHoder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent,false)
        return MyViewHoder(view)
    }

    override fun getItemCount(): Int {
        return contact.size
    }

    override fun onBindViewHolder(holder: MyViewHoder, position: Int) {
        val contactItem:Contact=contact[position]
        holder.name.text=contactItem.name
        holder.num.text=contactItem.number
        holder.itemView.setOnClickListener({
            val context=holder.itemView.context
            val intent=Intent(context,DetailsActivity::class.java)
            //onclick.onclick(contactItem,position)
            intent.putExtra("name", contactItem.name)
            intent.putExtra("number", contactItem.number)
            intent.putExtra("description", contactItem.description)

            context.startActivity(intent)
        })
    }
    interface OnClickItem{
        fun onclick(contact:Contact,index:Int)
    }
}