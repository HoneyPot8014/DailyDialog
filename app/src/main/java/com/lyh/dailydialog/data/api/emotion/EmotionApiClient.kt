package com.lyh.dailydialog.data.api.emotion

import com.lyh.dailydialog.R
import com.lyh.dailydialog.data.model.IoModel
import com.lyh.dailydialog.domain.entity.Emotion
import com.lyh.dailydialog.util.AppContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.FileNotFoundException
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

object EmotionApiClient {

    private const val baseUrl = "https://proxy.api.deepaffects.com/audio/generic/api/v2/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @JvmStatic
    suspend fun request(emotionRequest: EmotionRequest?) =
        suspendCoroutine<IoModel<Emotion?>> {
            retrofit.create(EmotionApi::class.java)
                .requestAnalyzeEmotion(
                    AppContext.context.getString(R.string.deep_affects_api_key),
                    emotionRequest?.params
                        ?: kotlin.run {
                            it.resume(IoModel.onFailed(FileNotFoundException()))
                            return@suspendCoroutine
                        },
                    "application/json"
                ).enqueue(object : Callback<Emotion> {
                    override fun onFailure(call: Call<Emotion>, t: Throwable) {
                        it.resume(IoModel.onFailed(t))
                    }

                    override fun onResponse(call: Call<Emotion>, response: Response<Emotion>) {
                        it.resume(IoModel.onSuccess(response.body()))
                    }
                })
        }
}
