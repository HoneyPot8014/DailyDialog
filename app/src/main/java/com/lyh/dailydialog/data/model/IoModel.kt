package com.lyh.dailydialog.data.model

open class IoModel<T> private constructor(
    @JvmField val status: Status = Status.FAILED,
    @JvmField val data: T? = null,
    @JvmField val error: Throwable? = null
) {

    companion object {

        @JvmStatic
        fun <T> onSuccess(result: T): IoModel<T> = IoModel(Status.SUCCESS, result, null)

        @JvmStatic
        fun <T> onFailed(error: Throwable): IoModel<T> = IoModel(Status.FAILED, null, error)
    }

    enum class Status {
        SUCCESS, FAILED
    }
}
