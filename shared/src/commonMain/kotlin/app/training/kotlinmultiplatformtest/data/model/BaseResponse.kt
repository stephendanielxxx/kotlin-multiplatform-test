package app.training.kotlinmultiplatformtest.data.model

import app.training.kotlinmultiplatformtest.domain.model.BaseModel

data class BaseResponse(
    val success: Boolean,
    val errorCode: String,
    val message: String
)

fun BaseResponse.toDomain() = BaseModel(success, errorCode, message)