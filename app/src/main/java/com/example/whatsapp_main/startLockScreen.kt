package com.example.whatsapp_main

import android.app.KeyguardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.whatsapp_main.databinding.ActivityStartLockScreenBinding

class startLockScreen : AppCompatActivity() {

    private lateinit var binding: ActivityStartLockScreenBinding

    private lateinit var keyguardManager: KeyguardManager // Used to check if the device has a screen lock set up
    private val AUTH_REQUEST_CODE = 1   // Request code for authenticating with the device password
    private var failedAttempts = 0      // Number of failed attempts to unlock the device
    private val maxAttempts = 5         // Maximum number of attempts before lockout
    private val lockoutTime = 3000L     // 30 seconds lockout

    override fun onCreate(savedInstanceState: Bundle?) {

        binding= ActivityStartLockScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)



        keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager  // Get the KeyguardManager system service

        if (keyguardManager.isKeyguardSecure) {  // Check if the device has a screen lock set up
            authenticateWithDevicePassword(binding.WhatsAppLocked, binding.unlockButton)
        } else {
            binding.WhatsAppLocked.text = "No screen lock is set up on this device!" // Display a message if no screen lock is set up
        }

        binding.unlockButton.setOnClickListener {
            authenticateWithDevicePassword(binding.WhatsAppLocked, binding.unlockButton)
        }
    }

    private fun authenticateWithDevicePassword(WhatsAppLocked: TextView, unlockButton: Button) {
        if (failedAttempts >= maxAttempts) {
            WhatsAppLocked.text = "Too many attempts! Wait 30 seconds..."
            unlockButton.isEnabled = false

            Handler(Looper.getMainLooper()).postDelayed({  // Reset the failed attempts count after the lockout time
                failedAttempts = 0
                WhatsAppLocked.text = "Try again"
                unlockButton.isEnabled = true
                authenticateWithDevicePassword(WhatsAppLocked, unlockButton)
            }, lockoutTime)
        } else {
            val intent = keyguardManager.createConfirmDeviceCredentialIntent("Unlock App", "Enter your phone's pattern, PIN, or password")
            if (intent != null) { // Check if the device supports authentication
                startActivityForResult(intent, AUTH_REQUEST_CODE)  // Start the authentication process
            } else {
                WhatsAppLocked.text = "Authentication not supported on this device"
            }
        }
    }

    @Deprecated("This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode == AUTH_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                failedAttempts = 0
                startActivity(Intent(this,MainActivity::class.java)).also { 
                    finish()
                }
            } else {
                failedAttempts++
                val remainingAttempts = maxAttempts - failedAttempts
                if (remainingAttempts > 0) {
                    binding.WhatsAppLocked.text = "Incorrect PIN/Pattern. Try again ($remainingAttempts attempts left)"
                    binding.unlockButton.visibility = Button.VISIBLE
                } else {
                    authenticateWithDevicePassword(binding.WhatsAppLocked, binding.unlockButton)
                }
            }
        }
    }
}
