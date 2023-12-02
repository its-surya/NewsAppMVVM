package com.example.newsappassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.text.style.TypefaceSpan
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.newsappassignment.databinding.ActivityNewsBinding
import com.example.newsappassignment.models.Article

class NewsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model = intent.getSerializableExtra("Name") as Article
        val newsHeading : TextView = findViewById(R.id.newsHeadLine)
        val newsDescription : TextView  = findViewById(R.id.newsDescription)

        val nd = model.title
        binding.newsAuthor.text ="~" + model.author
        newsHeading.text = formatFirstLetter(nd)
        newsDescription.text =  model.description
        Glide.with(this).load(model.urlToImage).into(binding.newsImages)


    }


    private fun formatFirstLetter(input: String): SpannableString {
        val formattedString = SpannableString(input)

        // Capitalize the first letter
        formattedString.setSpan(
            RelativeSizeSpan(1.5f), // Increase the text size
            0,
            1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        // Set the font to Times New Roman
        formattedString.setSpan(
            TypefaceSpan("times new roman"),
            0,
            1,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        return formattedString
    }
}