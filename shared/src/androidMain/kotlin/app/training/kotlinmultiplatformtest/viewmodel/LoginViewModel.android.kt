package app.training.kotlinmultiplatformtest.viewmodel

import app.training.kotlinmultiplatformtest.ViewState
import app.training.kotlinmultiplatformtest.domain.model.LoginDataModel
import kotlinx.coroutines.flow.StateFlow

actual class LoginViewModel actual constructor() {
    actual val uiState: StateFlow<ViewState<LoginDataModel>>
        get() = TODO("Not yet implemented")

    actual fun login(email: String, password: String) {
    }

    actual fun clear() {
    }
}