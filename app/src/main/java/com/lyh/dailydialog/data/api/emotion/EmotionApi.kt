package com.lyh.dailydialog.data.api.emotion

import com.lyh.dailydialog.domain.entity.Emotion
import retrofit2.Call
import retrofit2.http.*

interface EmotionApi {

    @POST("sync/recognise_emotion")
    fun requestAnalyzeEmotion(
        @Query("apiKey") apiKey: String,
        @Body params: Map<String, String>
    ): Call<Emotion>
}