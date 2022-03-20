package com.rawtooth.loginresgister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.rawtooth.medicineapp.MainActivity2
import com.rawtooth.medicineapp.R
import com.rawtooth.medicineapp.databinding.ActivityLoginBinding

class Login : AppCompatActivity(), View.OnClickListener {
    lateinit var bindig:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bindig.root)
        bindig.btnLogin.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val email=bindig.loginEdt1.text.toString()
        val pass=bindig.loginEdt2.text.toString()
        if(email=="admin@gmail.com"&&pass=="root"){
            Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,MainActivity2::class.java))
            finish()
        }
        else{
            Toast.makeText(this,"Invalid email/password",Toast.LENGTH_SHORT).show()
        }
    }
}