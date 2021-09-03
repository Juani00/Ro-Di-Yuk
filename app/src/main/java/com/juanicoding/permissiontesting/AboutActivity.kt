package com.juanicoding.permissiontesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

     // ketika pengguna mengklik tombol button, pengguna akan diarahkan ke arena permainan
        val btnNext = findViewById<Button>(R.id.btn_next)
        btnNext.setOnClickListener {
             val backToMain = Intent(this@AboutActivity, MainActivity::class.java)
             startActivity(backToMain)
        }
    }
}