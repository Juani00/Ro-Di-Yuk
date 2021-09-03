package com.juanicoding.permissiontesting

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRoll = findViewById<Button>(R.id.btn_roll)
        btnRoll.setOnClickListener {
            val handler = Handler()
            handler.postDelayed({
                    acakDadu()
                },3000) // acakDadu(), akan menampilkan text "...mendapatkan angka dadu: " setelah 3detik
        }


        // jika pengguna mengklik tombol panah kembali, maka akan diarahkan ke halaman About.
        val btnBack = findViewById<ImageView>(R.id.btn_back)
        btnBack.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
    }

    // method/function menampilkan dan mengacak dadu secara random
    @SuppressLint("ResourceType", "CutPasteId", "UseCompatLoadingForDrawables")
    private fun acakDadu() {
        val acakAngka1 = (1..6).random()
        val acakAngka2 = (1..6).random()
        var resultWin: Int = 0


        // pengecekan angka random, jika acakAngka1 == 1 maka akan menampilkan gambar dadu 1 di bagian "Bot",
        // juga jika acakAngka2 == 1, gambar dadu 1 akan ditampilkan di layar bagian "You"

        val resultDice2 = findViewById<ImageView>(R.id.result_dice2)
        when (acakAngka2) {                                                               // when() operator sama seperti if()
            1 -> resultDice2.setImageDrawable(resources.getDrawable(R.drawable.dadu_1))  // when(expression) {                 if(expression == expression) {
            2 -> resultDice2.setImageDrawable(resources.getDrawable(R.drawable.dadu_2))  //     expression -> do something..        do something...
            3 -> resultDice2.setImageDrawable(resources.getDrawable(R.drawable.dadu_3))  // }                                   }
            4 -> resultDice2.setImageDrawable(resources.getDrawable(R.drawable.dadu_4))
            5 -> resultDice2.setImageDrawable(resources.getDrawable(R.drawable.dadu_5))
            6 -> resultDice2.setImageDrawable(resources.getDrawable(R.drawable.dadu_6))
        }

        val resultDice1 = findViewById<ImageView>(R.id.result_dice)
        when (acakAngka1) {
            1 -> resultDice1.setImageDrawable(resources.getDrawable(R.drawable.dadu_1))
            2 -> resultDice1.setImageDrawable(resources.getDrawable(R.drawable.dadu_2))
            3 -> resultDice1.setImageDrawable(resources.getDrawable(R.drawable.dadu_3))
            4 -> resultDice1.setImageDrawable(resources.getDrawable(R.drawable.dadu_4))
            5 -> resultDice1.setImageDrawable(resources.getDrawable(R.drawable.dadu_5))
            6 -> resultDice1.setImageDrawable(resources.getDrawable(R.drawable.dadu_6))
        }


        // melakukan pengecekan, jika ternyata hasil tebakan "Bot" tidak sama dengan hasil acakan dadu "You" maka hanya akan menampilkan yang ada dibagian If
        // namun jika hasil tebakan "Bot" & "You" sama dengan hasil acakan dadu yang diputar, maka parameter showWin(Kamu Menang) pada bagian Else akan ditampilkan.
        if (acakAngka1 == acakAngka2) {
            val showWin = findViewById<TextView>(R.id.show_win)
            showWin.visibility = View.VISIBLE

            //menampilkan jumlah kemenangan yang telah diraih
            val jumlahMenang = findViewById<TextView>(R.id.jumlah_menang)

            val nilaiAwal: String = jumlahMenang.text.toString()  // nilai awal= 0
            resultWin = nilaiAwal.toInt()
            resultWin++
            jumlahMenang.text =
                resultWin.toString()  // jika hasil tebakan sama/pemain menang, nilai akan awal akan ditambah + 1


            Toast.makeText(
                this, "Bot mendapatkan angka dadu: $acakAngka1\n\n" +
                        "Kamu mendapatkan angka dadu: $acakAngka2",
                Toast.LENGTH_SHORT
            ).show()

        } else {
            val showWin = findViewById<TextView>(R.id.show_win)
            showWin.visibility = View.INVISIBLE

            Toast.makeText(
                this, "Bot mendapatkan angka dadu: $acakAngka1\n\n" +
                        "Kamu mendapatkan angka dadu: $acakAngka2",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}







