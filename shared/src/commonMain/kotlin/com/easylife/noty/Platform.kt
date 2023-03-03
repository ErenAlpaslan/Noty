package com.easylife.noty

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform