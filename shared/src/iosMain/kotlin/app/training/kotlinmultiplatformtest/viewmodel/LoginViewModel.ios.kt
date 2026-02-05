package app.training.kotlinmultiplatformtest.viewmodel

import app.training.kotlinmultiplatformtest.ViewState
import app.training.kotlinmultiplatformtest.domain.model.LoginDataModel
import kotlinx.coroutines.flow.StateFlow
import platform.darwin.NSObject

actual class LoginViewModel actual constructor() : NSObject() {
    private val viewModel = LoginViewModelImpl()

    actual val uiState: StateFlow<ViewState<LoginDataModel>>
        get() = viewModel.uiState

    actual fun login(email: String, password: String) {
        viewModel.login(email, password)
    }

    actual fun clear() {
        viewModel.clear()
    }
}