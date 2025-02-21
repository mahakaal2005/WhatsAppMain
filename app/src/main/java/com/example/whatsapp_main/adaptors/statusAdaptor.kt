package com.example.whatsapp_main.adaptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp_main.R
import com.example.whatsapp_main.dataClass.StatusCustomItem

class statusAdaptor(val updates:ArrayList<StatusCustomItem>):RecyclerView.Adapter<statusAdaptor.updatesViewHolder>(){
    inner class updatesViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        val profilePhoto:ImageView=itemview.findViewById(R.id.profilePhoto)
        val background:ConstraintLayout=itemview.findViewById(R.id.constraintBackground)
        val name:TextView=itemview.findViewById(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): updatesViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.status_custom_item,parent,false)
        return updatesViewHolder(view)
    }

    override fun onBindViewHolder(holder: updatesViewHolder, position: Int) {
        holder.profilePhoto.setImageResource((updates[position].profilePhoto))
        holder.background.setBackgroundResource((updates[position].backgroundPhoto))
        holder.name.text=updates[position].name
    }

    override fun getItemCount(): Int {
        return updates.size
    }
}
