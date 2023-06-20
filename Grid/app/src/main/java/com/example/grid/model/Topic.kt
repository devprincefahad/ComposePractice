package com.example.grid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val category: Int,
    val number: Int,
    @DrawableRes val icon: Int
)