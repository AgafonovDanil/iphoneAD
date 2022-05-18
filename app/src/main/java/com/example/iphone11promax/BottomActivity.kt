package com.example.iphone11promax

import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.iphone11promax.Retrofit.conn.getRetrofit
import com.example.iphone11promax.Retrofit.myRetrofit
import com.example.iphone11promax.databinding.ActivityBottomBinding
import com.example.iphone11promax.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Response




class BottomActivity : AppCompatActivity() {
    lateinit var foodRecyclerView: RecyclerView

    override fun onCreate(savedInstancesState: Bundle?){
        super.onCreate(savedInstancesState)
        setContentView(R.layout.activity_bottom)
        foodRecyclerView=findViewById(R.id.food_rec)

        val retrofit=getRetrofit()
        val call: Call<ArrayList<foodClass>> = retrofit.getDishes()
        call.enqueue(object :retrofit2.Callback<ArrayList<foodClass>>{
            override fun onResponse(
                call: Call<ArrayList<foodClass>>,
                response: Response<ArrayList<foodClass>>
            ) {
                foodRecyclerView.adapter=response.body()?.let { FoodAdapter(this@BottomActivity,it) }
            }

            override fun onFailure(call: Call<ArrayList<foodClass>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    /*private lateinit var binding: ActivityBottomBinding
    lateinit var sharedPreferences: SharedPreferences
    private var _binding: FragmentHomeBinding?=null

    override fun onCreate(savedInstancesState: Bundle?){
        super.onCreate(savedInstancesState)
        binding = ActivityBottomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_bottom)
        navView.setupWithNavController(navController)
    }*/
}