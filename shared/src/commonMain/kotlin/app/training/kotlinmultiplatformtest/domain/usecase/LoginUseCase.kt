package app.training.kotlinmultiplatformtest.domain.usecase
import app.training.kotlinmultiplatformtest.Resource
import app.training.kotlinmultiplatformtest.domain.model.LoginDataModel
import app.training.kotlinmultiplatformtest.domain.repository.AuthRepository

class LoginUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Resource<LoginDataModel> {
        val response = authRepository.login(email, password)

        return if(response.success && response.data != null){
            Resource.Success(response.data)
        }else{
            Resource.Error(response.errorCode)
        }
    }
}