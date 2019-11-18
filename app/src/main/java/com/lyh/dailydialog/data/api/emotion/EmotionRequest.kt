package com.lyh.dailydialog.data.api.emotion

import android.util.Base64
import com.lyh.dailydialog.data.model.IoModel
import kotlinx.coroutines.*
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class EmotionRequest private constructor() {

    companion object {
        private const val CONTENT = "content"
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

//        private suspend fun encode(filePath: String): IoModel<String> {
//            return suspendCoroutine { continuation ->
//                val file = File(filePath)
//                val inputStream by lazy {
//                    file.inputStream()
//                }
//                try {
//                    val encoded = ByteArray(file.length().toInt()).let {
//                        inputStream.read(it)
//                        Base64.encodeToString(it, Base64.DEFAULT)
//                    }
//                    continuation.resume(IoModel.onSuccess(encoded))
//                } catch (e: FileNotFoundException) {
//                    continuation.resume(IoModel.onFailed(e))
//                } finally {
//                    inputStream.close()
//                }
//            }
//        }
    }
}
