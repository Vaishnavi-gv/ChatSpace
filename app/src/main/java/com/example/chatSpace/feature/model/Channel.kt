package com.example.chatSpace.feature.model

data class Channel(
    val id: String ="",
    val name: String,
    val createdAt: Long= System.currentTimeMillis()
)