package com.example.wsde9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val login: TextInputLayout = findViewById(R.id.createLogin)
        val email: TextInputLayout = findViewById(R.id.createEmail)
        val password: TextInputLayout = findViewById(R.id.createPwd)
        val repeatPdw: TextInputLayout = findViewById(R.id.repeatPwd)

        if(login.editText?.text.toString() != " " ||
            email.editText?.text.toString() != " " ||
            password.editText?.text.toString() != " " ||
            repeatPdw.editText?.text.toString() != " "){

        }else{
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
        }
    }
}