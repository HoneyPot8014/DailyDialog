package com.lyh.dailydialog.data.api.emotion

import com.lyh.dailydialog.domain.entity.Emotion
import retrofit2.Call
import retrofit2.http.*

interface EmotionApi {

    @POST("audio/generic/api/v2/sync/recognise_emotion")
    fun requestAnalyzeEmotion(
        @Query("apikey") apiKey: String,
        @Body params: Map<String, String>
    ): Call<Emotion>
}