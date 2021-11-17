package com.example.testapplication.utils

data class Results<out T>(
    val status: Status,
    val data: T? = null,
    val exception: Throwable? = null
) {
    companion object {
        fun <T> success(data: T): Results<T> = Results(status = Status.SUCCESS, data = data)

        fun <T> error(exception: Throwable): Results<T> =
            Results(status = Status.ERROR, exception = exception)

        fun <T> loading(): Results<T> = Results(status = Status.LOADING)

        fun <T> done(): Results<T> = Results(status = Status.DONE)
    }
}