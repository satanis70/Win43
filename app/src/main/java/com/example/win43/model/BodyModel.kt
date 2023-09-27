package com.example.win43.model

import androidx.annotation.Keep

@Keep
data class BodyModel(
    val phoneName: String,
    val locale: String,
    val unique: String
)
