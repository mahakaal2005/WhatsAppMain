package com.example.whatsapp_main.adaptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp_main.R
import com.example.whatsapp_main.dataClass.chatCustomItem

// Correct RecyclerView Adapter and ViewHolder
class ChatAdaptor( val chatList: ArrayList<chatCustomItem>) :    // Add the correct RecyclerView.Adapter
    RecyclerView.Adapter<ChatAdaptor.ChatViewHolder>() {        // Add the correct RecyclerView.ViewHolder

    // ViewHolder class for RecyclerView
    inner class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        val lstMsg: TextView = view.findViewById(R.id.message)
        val time: TextView = view.findViewById(R.id.time)
        val photo: ImageView = view.findViewById(R.id.profilePhoto)
    }

    // Create ViewHolder (Inflate layout)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_custom_item, parent, false)
        return ChatViewHolder(view)
    }

    // Bind data to ViewHolder
    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat = chatList[position]
        holder.name.text = chat.name
        holder.lstMsg.text = chat.lst_msg
        holder.time.text = chat.time
        holder.photo.setImageResource(chat.photo)
    }

    // Return the total item count
    override fun getItemCount(): Int {
        return chatList.size
    }
}
