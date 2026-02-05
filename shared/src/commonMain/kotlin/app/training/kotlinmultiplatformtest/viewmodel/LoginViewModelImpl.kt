package app.training.kotlinmultiplatformtest.viewmodel

import app.training.kotlinmultiplatformtest.Resource
import app.training.kotlinmultiplatformtest.ViewState
import app.training.kotlinmultiplatformtest.data.remote.AuthApiService
import app.training.kotlinmultiplatformtest.data.repository.AuthRepositoryImpl
import app.training.kotlinmultiplatformtest.domain.model.LoginDataModel
import app.training.kotlinmultiplatformtest.domain.usecase.LoginUseCase
import app.training.kotlinmultiplatformtest.ktor.KtorClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModelImpl {
    private val scope = CoroutineScope(Dispatchers.Default) // or Dispatchers.IO if you prefer
    private val loginUseCase = LoginUseCase(AuthRepositoryImpl(AuthApiService(KtorClient.ktorClient)))

    private val _uiState = MutableStateFlow<ViewState<LoginDataModel>>(ViewState.loading(null))
    val uiState: StateFlow<ViewState<LoginDataModel>> = _uiState.asStateFlow()

    fun login(email: String, password: String) {
        scope.launch {
            _uiState.value = ViewState.loading(null)
            when (val result = loginUseCase(email, password)) {
                is Resource.Success -> {
                    _uiState.value = ViewState.success(result.data)
                }
                is Resource.Error -> {
                    _uiState.value = ViewState.error("error", null)
                }
            }
        }
    }

    fun clear() {
        _uiState.value = ViewState.loading(null)
    }

}

// shared/src/commonMain/kotlin/app/training/kotlinmultiplatformtest/LoginViewModel.kt


