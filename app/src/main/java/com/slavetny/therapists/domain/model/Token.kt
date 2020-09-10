package com.slavetny.therapists.domain.model

data class Token(
    // id_token is bad. Never use snake case as a variable name
    // idToken is also bad because your class name is Token so id should be enought
    val id: String
)