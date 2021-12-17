package com.example.wsde9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.wsde9.httpQueries.SignInRequest
import com.example.wsde9.httpQueries.SignInResponse
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var apiClient:ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiClient = ApiClient()

        val createNewAccount: TextView = findViewById(R.id.createAc)

        val login : TextInputLayout = findViewById(R.id.loginInput)
        val password: TextInputLayout = findViewById(R.id.passwordInput)

        val signIn: Button = findViewById(R.id.signIn)

//        signIn.visibility = View.INVISIBLE

        signIn.setOnClickListener{
//            startActivity(Intent(applicationContext, MainPage::javaClass))
            if(password.editText?.text.toString() != "" || login.editText?.text.toString() != ""){

                apiClient.getApiService().signin(SignInRequest(username = login.editText?.text.toString(), password = password.editText?.text.toString()))
                    .enqueue(object : Callback<SignInResponse> {
                        override fun onResponse(call: Call<SignInResponse>, response: Response<SignInResponse>
                        ) {
                            val loginResponse = response.body()
                            print(response.body().toString())
                            println(loginResponse?.token.toString() + " " + response.code() + " " + loginResponse)
                            if (response.code() == 200) {
                                print(loginResponse?.token.toString() + " token")
                                if (loginResponse != null) {
                                    print(loginResponse.token.toString() + " token")
                                    Toast.makeText(applicationContext,"ok", Toast.LENGTH_SHORT).show()
                                    startActivity(Intent(applicationContext, MainPage::class.java))
                                }

                            }
                            else {
                                Toast.makeText(applicationContext,"Неверный логин или пароль", Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                            print(t.printStackTrace().toString() + "dfsd")
                        }

                    })
            }else{
                Toast.makeText(this, "Заполните поля", Toast.LENGTH_SHORT).show()
            }

        }

        createNewAccount.setOnClickListener{
            startActivity(Intent(this, SignUp::class.java))
        }
    }
}