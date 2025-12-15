package com.ridhoafni.kmpmoviepedia

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform