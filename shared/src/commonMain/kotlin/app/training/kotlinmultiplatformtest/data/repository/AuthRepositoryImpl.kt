package app.training.kotlinmultiplatformtest.data.repository

import app.training.kotlinmultiplatformtest.data.model.toDomain
import app.training.kotlinmultiplatformtest.data.remote.AuthApiService
import app.training.kotlinmultiplatformtest.domain.model.LoginModel
import app.training.kotlinmultiplatformtest.domain.repository.AuthRepository

// Example usage in a repository
class AuthRepositoryImpl(private val apiService: AuthApiService): AuthRepository {
    override suspend fun login(email: String, password: String): LoginModel {
        try {
            val response = apiService.login(email, password)
            return response.toDomain()
        } catch (e: Exception) {
            throw Exception("Failed to login")
        }
    }
}
