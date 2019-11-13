package com.lyh.dailydialog.data.source

import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface RemoteEmotionSource {

    @POST("sync/recognise_emotion")
    fun requestAnalyzeEmotion(
        @Query("apiKey") apiKey: String,
        @QueryMap params: Map<String, String>
    )
}