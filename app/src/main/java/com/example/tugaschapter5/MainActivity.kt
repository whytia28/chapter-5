package com.example.tugaschapter5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntentExplicit.setOnClickListener {
            val intentExplicit = Intent(this, PersonActivity::class.java)
            intentExplicit.putExtra("nama", etNama.text.toString())
            intentExplicit.putExtra("alamat", etAlamat.text.toString())
            startActivity(intentExplicit)
        }

        btnIntentBundle.setOnClickListener {
            val orang = Bundle()
            orang.putString("nama", etNama.text.toString())
            orang.putString("alamat", etAlamat.text.toString())

            val intentBundle = Intent(this, PersonActivity::class.java)
            intentBundle.putExtra("bundle", orang)
            startActivity(intentBundle)
        }

        btnIntentParcelable.setOnClickListener {
            val orang = Person(etNama.text.toString(), etAlamat.text.toString())

            val intentParcelable = Intent(this, PersonActivity::class.java)
            intentParcelable.putExtra("object", orang)
            startActivity(intentParcelable)
        }

        btnImplicit.setOnClickListener {
            val intentImplicit = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "kirim")
                type = "text/plain"
            }
            if (intentImplicit.resolveActivity(packageManager) != null)
                startActivity(Intent.createChooser(intentImplicit, getString(R.string.kirim_ke)))
        }

    }
}