package com.example.newsappassignment.models

import java.io.Serializable

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
) : Serializable