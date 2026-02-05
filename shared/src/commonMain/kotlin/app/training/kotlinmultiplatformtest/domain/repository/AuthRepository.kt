package app.training.kotlinmultiplatformtest.domain.repository

import app.training.kotlinmultiplatformtest.domain.model.LoginModel

interface AuthRepository {
    suspend fun login(email: String, password: String): LoginModel
}