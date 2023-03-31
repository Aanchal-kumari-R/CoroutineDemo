package com.example.coroutinedemoactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.coroutinedemoactivity.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    var count:Int=0
    val TAG= "Coroutine"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.btnClick.setOnClickListener(this)
        binding.btnDownload.setOnClickListener(this)
    }

    override fun onClick(view:  View?) {
        when(view?.id) {
            R.id.btn_click -> {
                count++
             binding.tvCount.text=count.toString()
            }
            R.id.btn_download ->{
                downloading()

            }
        }
    }

    private fun downloading() {
     CoroutineScope(Dispatchers.IO).launch {
         for (i in 1..50000000) withContext(Dispatchers.Main) {
            // Log.d(TAG, "downloading: ${Thread.currentThread().name}: $i")
                 binding.tv2Count.text=i.toString()

     }

       }
          binding.tv2Count.text="completed.."
    }



}