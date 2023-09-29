package com.example.recipesapp.data.entity

import com.google.gson.annotations.SerializedName

data class TariflerCevap(@SerializedName("recipes") var tarifler:List<Tarifler>,
                         @SerializedName("success") var success :Int) {
}
/*
data class YemekCevap
    (@SerializedName("recipes") var recipes:List<Yemek>,
     @SerializedName("status") var status:Int,
     @SerializedName("message") var message:String){}

    @SerializedName("recipes") var recipes:List<Yemek>

 */