package app.training.kotlinmultiplatformtest.data.model

import app.training.kotlinmultiplatformtest.domain.model.LoginDataModel
import app.training.kotlinmultiplatformtest.domain.model.LoginModel

data class LoginResponse(
    val success: Boolean,
    val errorCode: String,
    val message: String,
    val data: LoginDataResponse?
)

data class LoginDataResponse(
    val userId: Int,
    val fullName: String,
    val email: String,
    val role: String,
    val profilePicture: String,
    val token: String,
    val refreshToken: String
)

fun LoginResponse.toDomain() = LoginModel(
    success, errorCode, message, data?.toDomain()
)

fun LoginDataResponse.toDomain() = LoginDataModel(
    userId = userId,
    fullName = fullName,
    email = email,
    role = role,
    profilePicture = profilePicture,
    token = token,
    refreshToken = refreshToken
)
