package com.loranttoth.newsapp.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.loranttoth.newsapp.R
import com.loranttoth.newsapp.data.model.New
import com.loranttoth.newsapp.databinding.NewListItemBinding
import androidx.core.content.ContextCompat.startActivity

const val EXTRA_NEWS_LINK = "com.loranttoth.gallerysorter.NEWSLINK"

class NewsAdapter(private val context: Context): RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
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
        holder.bind(newsList[position], context)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class MyViewHolder(val binding: NewListItemBinding):
        RecyclerView.ViewHolder(binding.root){


        fun bind(new:New, context: Context){
            binding.titleTextView.text = new.title
            binding.descTextView.text  = new.text
            binding.dateTextView.text = new.publish_date

            val posterURL = new.image

            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)

            itemView.setOnClickListener {
                val newsLink = new.url
                val intent = Intent(context, WebviewActivity::class.java).apply {
                    putExtra(EXTRA_NEWS_LINK, newsLink)
                }
                startActivity(context, intent, Bundle.EMPTY)
            }


        }



    }

}