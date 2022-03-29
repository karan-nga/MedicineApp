package com.rawtooth.medicineapp.consult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rawtooth.medicineapp.R

class consult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consult)
    }

    fun bookDoctor(view: View) {
        startActivity(Intent(this,doctor_consult::class.java))
    }
}