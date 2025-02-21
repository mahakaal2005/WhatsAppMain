package com.example.whatsapp_main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsapp_main.R
import com.example.whatsapp_main.adaptors.statusAdaptor
import com.example.whatsapp_main.dataClass.StatusCustomItem
import com.example.whatsapp_main.databinding.FragmentUpdatesBinding


class Updates : Fragment(R.layout.fragment_updates) {

    private lateinit var binding: FragmentUpdatesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentUpdatesBinding.bind(view)

        val profilePhoto= arrayOf(
            R.drawable.atul,
            R.drawable.anantjeet,
            R.drawable.faiqua,
            R.drawable.anant,
            R.drawable.rudra,
            R.drawable.utkristh
        )

        val background= arrayOf(
            R.drawable.atul,
            R.drawable.anantjeet,
            R.drawable.faiqua,
            R.drawable.anant,
            R.drawable.rudra,
            R.drawable.utkristh
        )

        val name= arrayOf("Atul", "Anantjeet", "Faiqua", "Anant", "Rudra", "Utkristh")

        var status=ArrayList<StatusCustomItem>()
        for(i in name.indices){
            val item=StatusCustomItem(profilePhoto[i],background[i],name[i])
            status.add(item)
        }

        val statusAdaptor= statusAdaptor(status)
        binding.statusRecyclerView.adapter=statusAdaptor
        binding.statusRecyclerView.layoutManager= LinearLayoutManager(requireContext())

    }




}