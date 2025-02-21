package com.example.whatsapp_main

import android.net.http.UrlRequest.Status
import android.os.Bundle
import android.provider.CallLog.Calls
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.whatsapp_main.databinding.ActivityMainBinding
import com.example.whatsapp_main.fragments.Chats
import com.example.whatsapp_main.fragments.Updates
import com.example.whatsapp_main.fragments.calls
import com.example.whatsapp_main.fragments.community

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load Chats Fragment by Default
        if (savedInstanceState == null) {
            loadFragment(Chats())
        }

        binding.bottomnav.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.chats -> loadFragment(Chats())
                R.id.communities -> loadFragment(community())
                R.id.calls -> loadFragment(calls())
                R.id.updates ->loadFragment(Updates())
            }
            true
        }
    }

    // Function to Load Fragment
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragments, fragment)
            .commit()
            Log.d("fragmentLoader", "Fragment Loaded")
    }
}
