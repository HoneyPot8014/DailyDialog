package com.lyh.dailydialog.data.api.emotion

import java.io.FileNotFoundException

class EmotionRequest private constructor() {

    companion object {
        const val CONTENT = "content"
        const val ENCODING = "encoding"
        const val SAMPLE_RATE = "sampleRate"
        const val LANGUAGE_CODE = "languageCode"
        const val URL = "url"
    }

    lateinit var params: Map<String, String>

    private constructor(params: Map<String, String>) : this() {
        this.params = params
    }

    class Builder {

        private val params = HashMap<String, String>()
        private var convertSuccessListener: (() -> Unit)? = null
        private var convertFailedListener: ((Throwable) -> Unit)? = null

        fun query(key: String, value: String): Builder {
            params[key] = value
            return this
        }

        fun setContent(filePath: String): Builder {
            params[CONTENT] = filePath
            return this
        }

        fun addOnConvertSuccessListener(onSuccess: () -> Unit) {
            this.convertSuccessListener = onSuccess
        }

        fun addOnConvertFailedListener(onFailed: (error: Throwable) -> Unit) {
            this.convertFailedListener = onFailed
        }

        fun build(): EmotionRequest? {
            if (params[CONTENT] == null) {
                convertFailedListener?.invoke(FileNotFoundException("null content"))
                return null
            }
            return EmotionRequest(params)
        }
    }
}
