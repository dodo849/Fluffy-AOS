package com.example.fluffy_aos.model.post

data class Post(
    val id: Long,
    val title: String,
    val subTitle: String,
    val imageUrl: String,
    val content: String = "포스팅 준비중 입니다 :)\n조금만 기다려주세요!"
)

