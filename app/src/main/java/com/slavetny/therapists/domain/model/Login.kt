package com.slavetny.therapists.domain.model

data class Login(
    val password: String,
    val rememberMe: Boolean,
    val username: String
)