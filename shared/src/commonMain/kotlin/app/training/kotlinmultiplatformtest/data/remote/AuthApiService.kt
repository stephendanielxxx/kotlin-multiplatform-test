package app.training.kotlinmultiplatformtest.data.remote

import app.training.kotlinmultiplatformtest.data.model.LoginResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class AuthApiService(private val client: HttpClient) {
    suspend fun login(email: String, password: String): LoginResponse {
        return client.get("api/v1/auth/login") {
            parameter("email", email)
            parameter("password", password)
        }.body()
    }

//    suspend fun register(email: String, password: String, fullName: String): RegisterResponse {
//        return client.post("api/v1/auth/register") {
//            contentType(ContentType.Application.Json)
//            setBody(mapOf(
//                "email" to email,
//                "password" to password,
//                "fullName" to fullName
//            ))
//        }.body()
//    }
}