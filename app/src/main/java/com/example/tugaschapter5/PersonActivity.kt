package com.example.tugaschapter5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_person.*

class PersonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        var nama = ""
        var alamat = ""

        if (intent.hasExtra("nama")) {
            nama = intent.getStringExtra("nama")!!
            alamat = intent.getStringExtra("alamat")!!
        }
        if (intent.hasExtra("bundle")) {
            val orang = intent.getBundleExtra("bundle")

            nama = orang?.getString("nama", null)!!
            alamat = orang.getString("alamat", null)!!
        }
        if (intent.hasExtra("object")) {
            val orang = intent.getParcelableExtra<Person>("object")

            nama = orang?.nama.toString()
            alamat = orang?.alamat.toString()
        }


        tvNama.text = nama
        tvAlamat.text = alamat
    }
}