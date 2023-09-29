package com.example.recipesapp.data.entity

import com.google.gson.annotations.SerializedName

data class CRUDCevap(@SerializedName("status") var status:Int,
                      @SerializedName("message") var message:String){

}
