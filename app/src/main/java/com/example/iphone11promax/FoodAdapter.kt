package com.example.iphone11promax

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FoodAdapter(val context: Context, val list:ArrayList<foodClass>):RecyclerView.Adapter<FoodAdapter.MyVH>()
{
    class MyVH(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = itemView.findViewById(R.id.image_food)
        val name: TextView = itemView.findViewById(R.id.tvname)
        val prise: TextView = itemView.findViewById(R.id.tvprice)
    }

    class feelings {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.food_scroll, parent, false)
        return MyVH(root)
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        Glide.with(context).load("http://food.madskill.ru/up/images/" + list[position].icon)
            .into(holder.imageView)
        holder.name.text = list[position].nameDish
        holder.prise.text = list[position].price
    }

    override fun getItemCount(): Int {
        return list.size
    }
}