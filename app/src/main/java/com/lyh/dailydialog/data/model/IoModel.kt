package com.lyh.dailydialog.data.model

open class IoModel<T> private constructor(
    @JvmField val status: Status,
    @JvmField val data: T?,
    @JvmField val error: Throwable?
) {
    enum class Status {
        SUCCESS, FAILED
    }

    companion object {

        @JvmStatic
        fun <T> onSuccess(result: T): IoModel<T> = IoModel(Status.SUCCESS, result, null)

        @JvmStatic
        fun <T> onFailed(error: Throwable): IoModel<T> = IoModel(Status.FAILED, null, error)
    }
}