package com.example.whatsapp_main.dataClass

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.whatsapp_main.R

data class StatusCustomItem(
    val profilePhoto: Int,
    val backgroundPhoto: Int,
    val name: String
)