package com.juanicoding.permissiontesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class OnBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

    /*
    pada awal ketika aplikasi pertama kali dibuka, tampilan awal layar akan menampilkan
    halaman OnBoarding/halaman awal (activity_on_boarding.xml).
    Setelah selesai terbuka, pengguna akan didiamkan dihalaman ini selama sampai 4detik
    kemudian akan dilanjutkan ke halaman berikutnya
     */
    val handler = Handler()
        handler.postDelayed({
            startActivity(Intent(this@OnBoardingActivity, AboutActivity::class.java))
        },4000)
    }
}