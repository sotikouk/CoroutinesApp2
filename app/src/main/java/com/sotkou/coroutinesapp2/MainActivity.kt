package com.sotkou.coroutinesapp2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sotkou.coroutinesapp2.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        helloTextMain()
        helloTextBackthread()

    }

    private fun helloTextBackthread() {
        CoroutineScope(Dispatchers.Main).launch {
            binding.textView1.text = "Hello from ${Thread.currentThread().name}"
        }
    }

    private fun helloTextMain() {
        CoroutineScope(Dispatchers.IO).launch {
            binding.textView2.text = "Hello from ${Thread.currentThread().name}"
        }
    }
}