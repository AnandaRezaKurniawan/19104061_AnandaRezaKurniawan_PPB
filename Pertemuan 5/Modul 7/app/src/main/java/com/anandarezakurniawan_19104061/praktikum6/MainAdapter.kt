package com.anandarezakurniawan_19104061.praktikum6

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.anandarezakurniawan_19104061.praktikum6.databinding.ItemListBinding

class MainAdapter (
    private val context: Context,
    private val listData: ArrayList<MyData>
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    class MainViewHolder (view : View) : RecyclerView.ViewHolder(view)

    private lateinit var binding: ItemListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        binding = ItemListBinding.bind(view)
        return MainViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = listData[position]

        binding.apply {
            ivPariwisata.load(data.photo){
                transformations(CircleCropTransformation())
            }
            tvNamaPariwisata.text = data.name
            tvDeskripsiPariwisata.text = data.description
        }

        holder.itemView.setOnClickListener {
            val moveWithObjectIntent = Intent(context, DetailActivity::class.java)
            moveWithObjectIntent.putExtra(DetailActivity.EXTRA_MYDATA, data)
            context.startActivity(moveWithObjectIntent)
        }
    }

    override fun getItemCount(): Int = listData.size
}