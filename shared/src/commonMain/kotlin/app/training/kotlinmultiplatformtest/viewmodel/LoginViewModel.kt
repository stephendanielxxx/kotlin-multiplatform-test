package app.training.kotlinmultiplatformtest.viewmodel

import app.training.kotlinmultiplatformtest.ViewState
import app.training.kotlinmultiplatformtest.domain.model.LoginDataModel
import kotlinx.coroutines.flow.StateFlow

expect class LoginViewModel() {
    val uiState: StateFlow<ViewState<LoginDataModel>>
    fun login(email: String, password: String)
    fun clear()
}