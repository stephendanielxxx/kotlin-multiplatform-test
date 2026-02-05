package app.training.kotlinmultiplatformtest.domain.model

data class BaseModel(
    val success: Boolean,
    val errorCode: String,
    val message: String
)