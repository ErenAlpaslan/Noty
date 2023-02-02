package com.github.noty

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform