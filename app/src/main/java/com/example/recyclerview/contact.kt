package com.example.recyclerview

import androidx.annotation.DrawableRes

data class Contact (
        @DrawableRes val image : Int,
        val name : String,
        val phone : String
)