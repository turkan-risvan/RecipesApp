package com.example.recipesapp.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Detay(
    @SerializedName("recipe") var recipe:Tarifler,
    @SerializedName("status") var success:Int,
    @SerializedName("message") var message:String): Serializable {
}
