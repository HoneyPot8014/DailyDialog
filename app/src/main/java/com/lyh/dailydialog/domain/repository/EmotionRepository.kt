package com.lyh.dailydialog.domain.repository

import com.lyh.dailydialog.domain.entity.Emotion

interface EmotionRepository {

    fun getEmotion(): Emotion

    fun setEmotion(emotion: Emotion)
}
