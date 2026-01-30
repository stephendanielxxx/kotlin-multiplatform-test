package app.training.kotlinmultiplatformtest

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform