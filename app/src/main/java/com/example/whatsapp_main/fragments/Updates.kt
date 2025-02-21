package com.example.whatsapp_main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.whatsapp_main.R
import com.example.whatsapp_main.adaptors.statusAdaptor
import com.example.whatsapp_main.dataClass.StatusCustomItem
import com.example.whatsapp_main.databinding.FragmentChatsBinding
import com.example.whatsapp_main.startLockScreen


class Updates : Fragment(R.layout.fragment_updates) {

    private lateinit var binding: FragmentChatsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentChatsBinding.inflate(layoutInflater)

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

        val updatesAdaptor=statusAdaptor(status)
        binding.recycle.adapter=updatesAdaptor
        binding.recycle.layoutManager=GridLayoutManager(requireContext(),4)

    }




}