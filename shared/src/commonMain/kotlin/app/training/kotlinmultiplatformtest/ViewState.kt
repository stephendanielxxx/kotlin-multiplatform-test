package app.training.kotlinmultiplatformtest

data class ViewState<out T>(val status: ResponseStatus, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): ViewState<T> {
            return ViewState(ResponseStatus.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): ViewState<T> {
            return ViewState(ResponseStatus.ERROR, data, msg)
        }

        fun <T> loading(data: T?): ViewState<T> {
            return ViewState(ResponseStatus.LOADING, data, null)
        }

        fun <T> empty(msg: String): ViewState<T> {
            return  ViewState(ResponseStatus.EMPTY, null, msg)
        }

        fun <T> networkError(msg: String = "Failed to process data"): ViewState<T> {
            return ViewState(ResponseStatus.NETWORK_ERROR, null, msg)
        }

        fun <T> tokenExpired(msg: String = "Your session is expired"): ViewState<T> {
            return ViewState(ResponseStatus.TOKEN_EXPIRED, null, msg)
        }
    }
}