package com.example.newsappassignment.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsappassignment.NewsActivity
import com.example.newsappassignment.R
import com.example.newsappassignment.models.Article

class NewsAdapter(private val articles: List<Article>, private val context: Context) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headImage: ImageView = itemView.findViewById(R.id.imageView)
        val headText: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate( R.layout.recyclerview_news_layout , parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = articles[position]
        Glide.with(context).load(newsItem.urlToImage).into(holder.headImage)
        holder.headText.text = newsItem.title


        holder.itemView.setOnClickListener {
            val intent = Intent(context , NewsActivity::class.java)
            intent.putExtra("Name", newsItem)
            context.startActivity(intent)
        }


    }
}