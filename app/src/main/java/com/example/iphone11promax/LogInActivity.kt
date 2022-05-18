package com.example.iphone11promax

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import com.example.iphone11promax.Retrofit.RetApi
import com.example.iphone11promax.Retrofit.conn
import com.example.iphone11promax.Retrofit.myRetrofit
import retrofit2.Call
import retrofit2.Response
import java.util.regex.Pattern.compile

lateinit var email: EditText
lateinit var pass: EditText
lateinit var sharedPreferences: SharedPreferences

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        email = findViewById(R.id.EmailAddress)
        pass = findViewById(R.id.Password)
        sharedPreferences = getSharedPreferences("main", MODE_PRIVATE)
    }

    fun isValidEmail(email:String):Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun logIn(view:android.view.View){
        if(email.text.isNotEmpty() && pass.text.isNotEmpty())
        {
            if(isValidEmail(email.text.toString()))
            {

                val getApi=conn.getRetrofit()
                var hashMap:HashMap<String,String> = HashMap<String,String>()
                hashMap.put("email",email.text.toString())
                hashMap.put("password", pass.text.toString())
                val log_call: retrofit2.Call<Login> = getApi.login(hashMap)
                log_call.enqueue(object:retrofit2.Callback<Login>{
                    override fun onResponse(call: Call<Login>, response: Response<Login>) {
                        if(response.isSuccessful)
                        {

                            /*val editor =  sharedPreferences.edit()
                            editor.putString("id",response.body()?.id)
                            editor.putString("avatar",response.body()?.avatar)
                            editor.putString("Name",response.body()?.Name)
                            editor.apply()*/
                            val menu = Intent(this@LogInActivity,BottomActivity::class.java)
                            startActivity(menu)
                        }
                        else {
                            Toast.makeText(this@LogInActivity, "Неверный пароль", Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<Login>, t: Throwable) {
                        Toast.makeText(this@LogInActivity,t.message, Toast.LENGTH_LONG).show()
                    }
                })
            }
            else
            {
                val alert = AlertDialog.Builder(this)
                    .setTitle("Неверно введённый Email")
                    .setPositiveButton("OK",null)
                    .create()
                    .show()
            }
        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка входа")
                .setMessage("У вас есть пустые поля")
                .setPositiveButton("OK",null)
                .create()
                .show()
        }








        /*email=findViewById(R.id.EmailAddress)
        pass=findViewById(R.id.Password)

        if(email.text.isNotEmpty() && pass.text.isNotEmpty() ){

            if (isValidEmail(email.text.toString())){ AlertDialog.Builder(this)
                .setTitle("Succeed")
                .setMessage("You succeefully logged in")
                .setPositiveButton("OK",null)
                .create()
                .show()
                val intent= Intent(this, BottomActivity::class.java)
                startActivity(intent)
            }
            else {
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("login is not correct")
                    .setPositiveButton("OK",null)
                    .create()
                    .show()
            }
            }
            else
            {
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("login or password is not correct")
                    .setPositiveButton("OK",null)
                    .create()
                    .show()
            }*/
        }
    }