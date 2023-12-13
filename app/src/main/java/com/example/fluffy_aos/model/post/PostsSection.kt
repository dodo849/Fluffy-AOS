package com.example.fluffy_aos.model.post

data class PostsSection(
    val id: Long,
    val category: String,
    val title: String,
    val posts: List<Post>,
)


// 더미
