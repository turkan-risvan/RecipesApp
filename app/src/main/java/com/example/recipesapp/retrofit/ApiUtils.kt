package com.example.recipesapp.retrofit

class ApiUtils {
    companion object {
        val BASE_URL = "https://api.canerture.com/recipes/"

        fun getTariflerDao():TariflerDao{
            return RetrofitClient.getClient(BASE_URL).create(TariflerDao::class.java)
        }
    }
}