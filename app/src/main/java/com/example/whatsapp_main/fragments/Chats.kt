package com.example.whatsapp_main.fragments

import android.os.Bundle
import com.example.whatsapp_main.databinding.FragmentChatsBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.whatsapp_main.R
import com.example.whatsapp_main.adaptors.ChatAdaptor
import com.example.whatsapp_main.dataClass.chatCustomItem


class Chats : Fragment(R.layout.fragment_chats) {

    private lateinit var binding:FragmentChatsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentChatsBinding.bind(view)

        // Sample Data
        val name = arrayOf("Atul", "Anantjeet", "Faiqua", "Anant", "Rudra", "Utkristh")
        val lastMessage = arrayOf("Hello", "Hi", "Hey", "How are you?", "I am fine", "I am good")
        val time = arrayOf("10:00", "10:01", "10:02", "10:03", "10:04", "10:05")
        val image = arrayOf(
            R.drawable.atul,
            R.drawable.anantjeet,
            R.drawable.faiqua,
            R.drawable.anant,
            R.drawable.rudra,
            R.drawable.utkristh
        )

        // Create Chat List
        var chats = ArrayList<chatCustomItem>()
        for (i in name.indices) {
            val item = chatCustomItem(name[i], lastMessage[i], time[i], image[i])
            chats.add(item)
        }

        // Set RecyclerView
        val chatAdaptor=ChatAdaptor(chats)
        binding.recycle.adapter= chatAdaptor
        binding.recycle.layoutManager= LinearLayoutManager(requireContext())

    }


}
