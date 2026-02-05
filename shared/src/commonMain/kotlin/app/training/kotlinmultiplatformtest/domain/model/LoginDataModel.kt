package app.training.kotlinmultiplatformtest.domain.model

data class LoginModel(
    val success: Boolean,
    val errorCode: String,
    val message: String,
    val data: LoginDataModel?
)

data class LoginDataModel(
    val userId: Int,
    val fullName: String,
    val email: String,
    val role: String,
    val profilePicture: String,
    val token: String,
    val refreshToken: String
)
