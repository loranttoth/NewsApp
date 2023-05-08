package com.loranttoth.newsapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.loranttoth.newsapp.R
import com.loranttoth.newsapp.data.model.New
import com.loranttoth.newsapp.databinding.NewListItemBinding

class NewsAdapter(): RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    private val newsList = ArrayList<New>()

    fun setList(news: List<New>){
        newsList.clear()
        newsList.addAll(news)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : NewListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.new_list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class MyViewHolder(val binding: NewListItemBinding):
        RecyclerView.ViewHolder(binding.root){


        fun bind(new:New){
            binding.titleTextView.text = new.title
            binding.descTextView.text  = new.text
            binding.dateTextView.text = new.publish_date

            val posterURL = new.image

            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)


        }



    }

}